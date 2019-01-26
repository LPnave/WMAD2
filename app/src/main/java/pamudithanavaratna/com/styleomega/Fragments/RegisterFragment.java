package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import pamudithanavaratna.com.styleomega.Database.Login;
import pamudithanavaratna.com.styleomega.Database.User;
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

        final EditText firstname = v.findViewById(R.id.editTextFirstName);
        final EditText lastname = v.findViewById(R.id.editTextLastName);
        final EditText email  = v.findViewById(R.id.editTextEmail);
        final EditText mobilenumber = v.findViewById(R.id.editTextMobileNumber);
        final EditText password = v.findViewById(R.id.editTextPassword);

        registerNextBtn = v.findViewById(R.id.RegisterNextbtn);
        registerNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkresult = false;
                try {
                    User check = User.find(User.class, "email=?", email.getText().toString()).get(0);
                    if(check!=null) {
                        checkresult=true;
                    }
                }catch(IndexOutOfBoundsException e){
                    checkresult = false;
                }
                if(!checkresult) {
                    User user = new User(email.getText().toString(), firstname.getText().toString(),
                            lastname.getText().toString(),
                            mobilenumber.getText().toString(), password.getText().toString());

                    user.save();

                    Login userlogin = new Login(email.getText().toString(), password.getText().toString());
                    userlogin.save();

                    Bundle userbundle = new Bundle();
                    userbundle.putSerializable("newuser", user);

                    AddressFragment AF = new AddressFragment();
                    AF.setArguments(userbundle);

                    Sign_In.fragmentManager.beginTransaction().replace(R.id.SignInFragmentContainer,
                            AF, null).addToBackStack("tag2").commit();
                }else{
                    Toast.makeText(getContext(),"You already have an account",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }



}
