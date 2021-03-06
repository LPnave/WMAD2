package pamudithanavaratna.com.styleomega.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import pamudithanavaratna.com.styleomega.Activities.MainPage;
import pamudithanavaratna.com.styleomega.Adapters.CustomSharedPreference;
import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.R;
import pamudithanavaratna.com.styleomega.Activities.Sign_In;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

     Button SignInBtn;
     Button RegisterBtn;

    private CustomSharedPreference preference;

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preference = CustomSharedPreference.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_sign_in, container, false);

        final EditText email = v.findViewById(R.id.emailSignIn);
        final EditText password = v.findViewById(R.id.passwordSignIn);

        SignInBtn = (Button) v.findViewById(R.id.SignInBtn);
        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailcheck= email.getText().toString();
                String passwordcheck = password.getText().toString();

                try {
                    if(!emailcheck.equals("") && !passwordcheck.equals("")) {

                        List<User> userlog = User.listAll(User.class);
                        for (User u : userlog) {
                            if (u.getEmail().equals(emailcheck) && u.getPassword().equals(passwordcheck)) {

                                preference.putALong(getContext(),"userid",u.getId());
                                preference.putABool(getContext(),"loginstatus",true);

                                Intent movingtomain= new Intent(getActivity(), MainPage.class);

                                startActivity(movingtomain);
                                getActivity().finish();
                            }
                        }
                        //Toast.makeText(getContext(), "Login failed", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(getContext(),"Fill all feilds",Toast.LENGTH_SHORT).show();
                    }
               }
                catch (Exception e){
                    Log.i("exception ", e.getMessage());
                }
            }
        });

        RegisterBtn = (Button) v.findViewById(R.id.RegisterBtn);
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
