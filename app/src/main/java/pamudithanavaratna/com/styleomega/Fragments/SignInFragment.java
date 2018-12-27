package pamudithanavaratna.com.styleomega.Fragments;


import android.content.Intent;
import android.os.Bundle;
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
import pamudithanavaratna.com.styleomega.Database.Login;
import pamudithanavaratna.com.styleomega.Database.User;
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

        final EditText email = v.findViewById(R.id.emailSignIn);
        final EditText password = v.findViewById(R.id.passwordSignIn);

        //Sign in Button
        SignInBtn = v.findViewById(R.id.SignInBtn);
        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailcheck= email.getText().toString();
                String passwordcheck = password.getText().toString();

                try {

                   // List<Login> userlog = Login.find(Login.class, "useremail=?",emailcheck);
                    List<Login> userlog = Login.listAll(Login.class);

                    for(Login l : userlog){
                        if(l.getUseremail()== emailcheck && l.getPassword()==passwordcheck){
                            startActivity(new Intent(getActivity(), MainPage.class));
                            getActivity().finish();

                        }
                        else {
                            Toast.makeText(getContext(),"Login failed",Toast.LENGTH_SHORT).show();
                        }

                    }

                }
                catch (Exception e){
                    Log.i("exception ", e.getMessage());

                }
//test line
               /* List<User> userList = User.findWithQuery(User.class, "Select * from User where email="+ emailcheck + " and password="+ passwordcheck);

                if(userList!=null) {

                    startActivity(new Intent(getActivity(), MainPage.class));
                    getActivity().finish();
                }
                else{

                    Toast.makeText(getContext(),"Login failed",Toast.LENGTH_SHORT).show();
                }*/
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
