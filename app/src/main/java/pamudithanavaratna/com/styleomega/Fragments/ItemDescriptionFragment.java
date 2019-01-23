package pamudithanavaratna.com.styleomega.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import pamudithanavaratna.com.styleomega.Adapters.CustomSharedPreference;
import pamudithanavaratna.com.styleomega.Database.CartDB;
import pamudithanavaratna.com.styleomega.Database.OrderItem;
import pamudithanavaratna.com.styleomega.Database.Products;
import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemDescriptionFragment extends Fragment {



    long id;

    Button addtocart;
    Button sharingbutton;
    User account;
    Products p;

    int inputamout;
    int integerprice;
    String output;
    String size;

    //private SharedPreferences preferences;
    private CustomSharedPreference preference = new CustomSharedPreference();

    public ItemDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         id = getArguments().getLong("itemID");
         p = Products.findById(Products.class,id);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_item_description, container, false);

        TextView nametext = v.findViewById(R.id.itemname);
        TextView pricetext = v.findViewById(R.id.priceTextView);
        TextView stocktext = v.findViewById(R.id.TextViewStock);
        ImageView imagedes = v.findViewById(R.id.itemdesImage);
        final TextView subTotal = v.findViewById(R.id.subtotalTextView);
        final EditText amount = v.findViewById(R.id.noofitemsinput);
         addtocart= v.findViewById(R.id.AddtoCartButton);
        Spinner sizespinner = v.findViewById(R.id.sizespinner);


        Picasso.get().load(p.getPicture()).into(imagedes);

        nametext.setText(p.getProductName());
        pricetext.setText(p.getPrice());
        stocktext.setText(p.getStock()+"");

        ArrayAdapter<String> sizeadapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.sizes));
        sizeadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sizespinner.setAdapter(sizeadapter);

        size = sizespinner.getSelectedItem().toString();

        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try{
                    inputamout = Integer.parseInt(charSequence.toString());
                }catch(NumberFormatException ex){
                    Toast.makeText(getContext(),"Please enter a value",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                 integerprice = Integer.parseInt(p.getPrice());
                int calc = inputamout*integerprice;
                output = Integer.toString(calc);
                subTotal.setText(output);
            }
        });

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String date = simpleDateFormat.format(calendar.getTime());

                //preferences = getActivity().getSharedPreferences("user",Context.MODE_PRIVATE);
                //long id = preferences.getLong("userid",0);
                long id = preference.getALong(getContext(),"userid");

                account = User.findById(User.class,id);

                int newstock = p.getStock() - inputamout;
                p.setStock(newstock);
                p.save();

                OrderItem check= checkorder(p.getProductName());
                CartDB neworder;
                if(check== null){
                    OrderItem newbundleorder = new OrderItem(p.getProductName(),inputamout,"Saved",output,p.getPicture(),p.getPrice(),account);
                    newbundleorder.save();

                    neworder = new CartDB(newbundleorder,p,inputamout,size,date);
                    neworder.save();
                }
                else{
                    //for(int i=0;i<=check.size();i++)
                    check.setSubtotal(output);
                    check.setTotalquantity(inputamout);
                    check.save();
                       // System.out.println(i);
                    neworder = new CartDB(check,p,inputamout,size,date);
                    neworder.save();

                }


                Toast.makeText(getContext(),"Added to Cart",Toast.LENGTH_SHORT).show();

                ItemDescriptionFragment fragment = (ItemDescriptionFragment)
                        getFragmentManager().findFragmentById(R.id.MainContainer);

                getFragmentManager().beginTransaction()
                        .detach(fragment)
                        .attach(fragment)
                        .commit();
            }
        });

        sharingbutton = v.findViewById(R.id.sharebutton);
        sharingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareproduct();
            }
        });

        return v;
    }

    private OrderItem checkorder(String productName) {
        int x = OrderItem.listAll(OrderItem.class).size();
        if(x>0) {
            try {
                OrderItem odb = OrderItem.find(OrderItem.class, "itemname = ? and status = ?", productName, "Saved").get(0);
                if (odb != null) {
                    return odb;
                }
                return null;
            }
            catch (IndexOutOfBoundsException ex){
                return null;
            }
        }
        return null;
    }

    private void shareproduct(){
        String s = "visit style omega for your shopping pleasures";
        Intent shareintent = new Intent(android.content.Intent.ACTION_SEND);
        shareintent.setType("text/plain");
        shareintent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        shareintent.putExtra(android.content.Intent.EXTRA_TEXT, s);

        startActivity(Intent.createChooser(shareintent,"Share via"));

    }
}
