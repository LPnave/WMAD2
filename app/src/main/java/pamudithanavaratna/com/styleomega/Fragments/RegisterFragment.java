package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pamudithanavaratna.com.styleomega.R;
import pamudithanavaratna.com.styleomega.Activities.Sign_In;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private Button registerNextBtn;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        registerNextBtn = v.findViewById(R.id.RegisterNextbtn);
        registerNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Intent intent = new Intent(getActivity(),MainPage.class);
                Sign_In.fragmentManager.beginTransaction().replace(R.id.SignInFragmentContainer,
                        new AddressFragment(),null).addToBackStack("tag2").commit();
                //startActivity(new Intent(getActivity(),MainPage.class));
                //getActivity().finish();

            }
        });
        return v;
    }



}
