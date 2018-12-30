package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pamudithanavaratna.com.styleomega.Activities.MainPage;
import pamudithanavaratna.com.styleomega.Database.Products;
import pamudithanavaratna.com.styleomega.R;
import pamudithanavaratna.com.styleomega.RecyclerViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsPageFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Products> productsarray;

    public ItemsPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        productsarray = new ArrayList<>();

        JSONObject json  = null;
        try {

            Bundle bundle = new Bundle();
            json = new JSONObject(loadJSON("Products.json"));

            String gender = (String) getArguments().getSerializable("gender");
            String category = (String) getArguments().getSerializable("category");
            String key = gender+category;

            if(gender.equals("Women")) {

                JSONArray productlist = json.getJSONArray("womenproducts");

                for (int i = 0; i < productlist.length(); i++) {
                    JSONObject product = productlist.getJSONObject(i);

                    if (key.equals(product.getString("Category"))) {

                        String itemname = product.getString("Name");
                        String itemurl = product.getString("Image");


                        productsarray.add(new Products(itemname, itemurl));
                    }
                }
            }
            else if(gender.equals("Men")){
                JSONArray productlist = json.getJSONArray("menproducts");
                for (int i = 0; i < productlist.length(); i++) {
                    JSONObject product = productlist.getJSONObject(i);

                    if (key.equals(product.getString("Category"))) {

                        String itemname = product.getString("Name");
                        String itemurl = product.getString("Image");


                        productsarray.add(new Products(itemname, itemurl));
                    }
                }
            }
            else {
                Toast.makeText(getContext(),"ERROR",Toast.LENGTH_SHORT);
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_items_page,container,false);

        recyclerView = v.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        recyclerViewAdapter = new RecyclerViewAdapter(productsarray,getContext());
        recyclerView.setAdapter(recyclerViewAdapter);


        return v;
    }




    public String loadJSON (String filename){
        String json = null;

        try{
            InputStream is = getActivity().getAssets().open(filename);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        }
        catch(IOException e){
            e.printStackTrace();
            return  null;
        }
        return json;

    }

}
