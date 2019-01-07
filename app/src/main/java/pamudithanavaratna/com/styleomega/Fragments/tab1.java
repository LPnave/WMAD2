package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import pamudithanavaratna.com.styleomega.Activities.MainPage;
import pamudithanavaratna.com.styleomega.GridAdapter;
import pamudithanavaratna.com.styleomega.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class tab1 extends Fragment {

    GridView gview;
    Bundle bundle;
    //String gender="Women";
    String[] categories ={"Tops", "Bottoms", "Accessories", "Footwear", "Partywear", "Coats & Jackets"};

    int[] images ={
            R.drawable.wtop,
            R.drawable.woman_bottoms,
            R.drawable.woman_accessories,
            R.drawable.womenshoes,
            R.drawable.wparty,
            R.drawable.wcoat
    };


    public tab1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         v= inflater.inflate(R.layout.fragment_tab1, container, false);
        /*categoryBtnW = v.findViewById(R.id.catergoryBtnWomen);
        categoryBtnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainPage.fragmentManager.beginTransaction().add(R.id.MainContainer,
                        new ItemsPageFragment(), null).addToBackStack("mainPageW").commit();
            }
        });*/



        gview = (GridView) v.findViewById(R.id.gridview);
        final GridAdapter gridAdapter = new GridAdapter(getActivity(),categories,images);
        gview.setAdapter(gridAdapter);

        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String category = gridAdapter.getItemName(i);

                bundle = new Bundle();
                bundle.putString("category", category);
                bundle.putString("gender","Women");

                Toast.makeText(getContext(),category +" Women",Toast.LENGTH_SHORT).show();

                ItemsPageFragment IPF = new ItemsPageFragment();
                IPF.setArguments(bundle);

                MainPage.fragmentManager.beginTransaction().add(R.id.MainContainer,
                        IPF, null).addToBackStack("mainPageW").commit();
            }
        });

        return v;
    }


}

