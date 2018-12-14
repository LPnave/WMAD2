package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pamudithanavaratna.com.styleomega.Activities.MainPage;
import pamudithanavaratna.com.styleomega.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class tab1 extends Fragment {

    private Button categoryBtnW;

    public tab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_tab1, container, false);
        categoryBtnW = v.findViewById(R.id.catergoryBtnWomen);
        categoryBtnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainPage.fragmentManager.beginTransaction().add(R.id.MainContainer,
                        new ItemsPageFragment(), null).addToBackStack("mainPageW").commit();
            }
        });
        return v;
    }

}
