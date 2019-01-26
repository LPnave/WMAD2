package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pamudithanavaratna.com.styleomega.Database.PaymentDetails;
import pamudithanavaratna.com.styleomega.Database.ShippingDetails;
import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.R;
import pamudithanavaratna.com.styleomega.Activities.Sign_In;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddressFragment extends Fragment {

    private Button AddressBtn;

    public AddressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_address,container,false);

        final EditText address = v.findViewById(R.id.AddresseditText);
        final EditText streetname = v.findViewById(R.id.editTextStreetName);
        final EditText district = v.findViewById(R.id.editTextDistrict);
        final EditText province = v.findViewById(R.id.editTextProvince);
        final EditText postalcode = v.findViewById(R.id.editTextPostalCode);

        final Bundle bundle = new Bundle();
        final User user = (User) getArguments().getSerializable("newuser");


       AddressBtn= v.findViewById(R.id.AddressNextBtn);
       AddressBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {


                 ShippingDetails sd = new ShippingDetails(address.getText().toString(), streetname.getText().toString(),
                         district.getText().toString(),province.getText().toString(),Integer.parseInt(postalcode.getText().toString()),user);
                    sd.save();
                    bundle.putSerializable("newuser",user);
                 PaymentDetailsFragment pdf = new PaymentDetailsFragment();
                 pdf.setArguments(bundle);

                 Sign_In.fragmentManager.beginTransaction().replace(R.id.SignInFragmentContainer,
                         pdf,null).addToBackStack("tag3").commit();
             }
         }

       );

       return v;
    }

}
