package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import pamudithanavaratna.com.styleomega.Database.Products;
import pamudithanavaratna.com.styleomega.R;
import pamudithanavaratna.com.styleomega.ItemRecyclerViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsPageFragment extends Fragment {

    private RecyclerView recyclerView;
    private ItemRecyclerViewAdapter itemRecyclerViewAdapter;

    private List<Products> filterproducts;

    public ItemsPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String categroy = getArguments().getString("category");
        String gender = getArguments().getString("gender");

        filterproducts = Products.find(Products.class,"gender=? and category=?",gender,categroy);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_items_page,container,false);

        recyclerView = v.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        itemRecyclerViewAdapter = new ItemRecyclerViewAdapter((ArrayList<Products>) filterproducts,getContext());
        recyclerView.setAdapter(itemRecyclerViewAdapter);

        return v;
    }








}
