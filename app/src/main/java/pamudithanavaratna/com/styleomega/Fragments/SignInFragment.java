package pamudithanavaratna.com.styleomega.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.Iterator;
import java.util.List;

import pamudithanavaratna.com.styleomega.Activities.MainPage;
import pamudithanavaratna.com.styleomega.CustomSharedPreference;
import pamudithanavaratna.com.styleomega.Database.Login;
import pamudithanavaratna.com.styleomega.Database.OrderItem;
import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.R;
import pamudithanavaratna.com.styleomega.Activities.Sign_In;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

     Button SignInBtn;
     Button RegisterBtn;

    //private SharedPreferences preferences;
    //private SharedPreferences.Editor editor;
    private CustomSharedPreference preference = new CustomSharedPreference();

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_sign_in, container, false);

        final EditText email = v.findViewById(R.id.emailSignIn);
        final EditText password = v.findViewById(R.id.passwordSignIn);



        //Sign in Button
        SignInBtn = (Button) v.findViewById(R.id.SignInBtn);
        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailcheck= email.getText().toString();
                String passwordcheck = password.getText().toString();

                try {
                    if(emailcheck!=null && passwordcheck!=null) {
                        // List<Login> userlog = Login.find(Login.class, "useremail=?",emailcheck);
                        List<User> userlog = User.listAll(User.class);
                        for (User u : userlog) {
                            if (u.getEmail().equals(emailcheck) && u.getPassword().equals(passwordcheck)) {


                                preference.putALong(getContext(),"userid",u.getId());
                                preference.putABool(getContext(),"loginstatus",true);

                                //preferences = getContext().getSharedPreferences("user",Context.MODE_PRIVATE);
                                //editor = preferences.edit();

                               // editor.putLong("userid",u.getId());
                               // editor.putBoolean("loginstatus",true);
                               // editor.commit();


                                /*String name = u.getFname()+" "+u.getLname();
                                Bundle bundle = new Bundle();
                                bundle.putString("useremail",emailcheck);
                                bundle.putString("username",name);
                                //bundle.putSerializable("loggeduser",u);*/

                                Intent movingtomain= new Intent(getActivity(), MainPage.class);
                               // movingtomain.putExtra("loggeduser",u);
                                //movingtomain.putExtras(bundle);


                                startActivity(movingtomain);
                                getActivity().finish();

                            } else {
                                Toast.makeText(getContext(), "Login failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }else
                    {
                        Toast.makeText(getContext(),"Fill all feilds",Toast.LENGTH_SHORT);
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
