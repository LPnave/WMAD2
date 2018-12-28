package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import pamudithanavaratna.com.styleomega.Activities.MainPage;
import pamudithanavaratna.com.styleomega.GridAdapter;
import pamudithanavaratna.com.styleomega.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class tab2 extends Fragment {

    GridView gview;

    String[] categories ={"Tops", "Bottoms", "Accessories", "Footwear", "Party wear", "Coats & Jackets"};

    int[] images ={
            R.drawable.men_top,
            R.drawable.menbottom,
            R.drawable.maccessories,
            R.drawable.men_shoes,
            R.drawable.mparty,
            R.drawable.mcoat
    };

    public tab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_tab2, container, false);
        /*categoryBtnM = v.findViewById(R.id.catergoryBtnMen);
        categoryBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainPage.fragmentManager.beginTransaction().add(R.id.MainContainer,
                        new ItemsPageFragment(), null).addToBackStack("mainPageM").commit();
            }
        });*/

        gview = (GridView) v.findViewById(R.id.gridview);
        GridAdapter gridAdapter = new GridAdapter(getActivity(),categories,images);
        gview.setAdapter(gridAdapter);

        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainPage.fragmentManager.beginTransaction().add(R.id.MainContainer,
                        new ItemsPageFragment(), null).addToBackStack("mainPageM").commit();
            }
        });

        return  v;
    }

}
