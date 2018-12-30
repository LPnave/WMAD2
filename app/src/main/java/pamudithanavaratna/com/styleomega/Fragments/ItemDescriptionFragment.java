package pamudithanavaratna.com.styleomega.Fragments;


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
import java.util.Date;

import pamudithanavaratna.com.styleomega.Database.OrderItem;
import pamudithanavaratna.com.styleomega.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemDescriptionFragment extends Fragment {

    String image;
    String price;
    String name;

    Button addtocart;

    int inputamout;
    int integerprice;
    String output;
    String size;

    public ItemDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         image = getArguments().getString("image");
         price = getArguments().getString("itemprice");
         name = getArguments().getString("itemname");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_item_description, container, false);

        TextView nametext = v.findViewById(R.id.itemname);
        TextView pricetext = v.findViewById(R.id.priceTextView);
        ImageView imagedes = v.findViewById(R.id.itemdesImage);
        final TextView subTotal = v.findViewById(R.id.subtotalTextView);
        final EditText amount = v.findViewById(R.id.noofitemsinput);
        Button addtocart= v.findViewById(R.id.AddtoCartButton);
        Spinner sizespinner = v.findViewById(R.id.sizespinner);


        Picasso.get().load(image).into(imagedes);

        nametext.setText(name);
        pricetext.setText(price);

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
                 inputamout = Integer.parseInt(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                 integerprice = Integer.parseInt(price);
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

                OrderItem neworder = new OrderItem(name,inputamout,size,date,"saved",image);
                neworder.save();

                Toast.makeText(getContext(),"Order placed",Toast.LENGTH_SHORT);
            }
        });

        return v;
    }

}
