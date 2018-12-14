package pamudithanavaratna.com.styleomega.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pamudithanavaratna.com.styleomega.Activities.MainPage;
import pamudithanavaratna.com.styleomega.R;
import pamudithanavaratna.com.styleomega.Activities.Sign_In;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    private Button SignInBtn;
    private Button RegisterBtn;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_sign_in, container, false);

        //Sign in Button
        SignInBtn = v.findViewById(R.id.SignInBtn);
        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),MainPage.class));
                getActivity().finish();
            }
        });


        //Register Button
        RegisterBtn = v.findViewById(R.id.RegisterBtn);
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sign_In.fragmentManager.beginTransaction().replace(R.id.SignInFragmentContainer,
                        new RegisterFragment(),null).addToBackStack("tag").commit();
            }
        });
        return v;

    }

}
