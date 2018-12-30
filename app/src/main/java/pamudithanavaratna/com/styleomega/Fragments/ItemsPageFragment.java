package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_items_page,container,false);

        recyclerView = v.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        productsarray = new ArrayList<>();

        JSONObject json  = null;
        try {
            json = new JSONObject(loadJSON("Products.json"));
            JSONArray productlist = json.getJSONArray("allproducts");

            for(int i =0; i<productlist.length();i++){
                JSONObject product = productlist.getJSONObject(i);

                String itemname = product.getString("Name");
                String itemurl = product.getString("Image");

                productsarray.add(new Products(itemname,itemurl));

            }

            recyclerViewAdapter = new RecyclerViewAdapter(productsarray,getContext());
            recyclerView.setAdapter(recyclerViewAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return v;
    }

    public void parseJSON(JSONArray productjson){
        JSONObject json = null;

        try{
            json = new JSONObject(loadJSON("Products.json"));
            JSONArray productlist = json.getJSONArray("allproducts");
        }
        catch(JSONException e){
            e.printStackTrace();
        }

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
