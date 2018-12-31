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

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import pamudithanavaratna.com.styleomega.Activities.MainPage;
import pamudithanavaratna.com.styleomega.Database.PaymentDetails;
import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentDetailsFragment extends Fragment {

    private Button completeReg;

    public PaymentDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_payment_details,container,false);

        final EditText accountNumber = v.findViewById(R.id.editTextAccountNumber);
        final EditText vsc = v.findViewById(R.id.editTextVSC);
        final EditText exDate = v.findViewById(R.id.editTextExpDate);

        Bundle bundle = new Bundle();
        //final User user = (User) bundle.getSerializable("newuser");
        final User user = (User) getArguments().getSerializable("newuser");

        completeReg= v.findViewById(R.id.buttonCompleteRegstration);
        completeReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            try {

                ParsePosition pp = new ParsePosition(0);
                PaymentDetails pd = new PaymentDetails(accountNumber.getText().toString(),
                        Integer.parseInt(vsc.getText().toString()),
                        new SimpleDateFormat("dd/mm/yyyy").parse(exDate.getText().toString(),pp),
                        user);

                pd.save();

            }catch (Exception e){

                Log.d("parse","Parse Exception Fired");
            }
                startActivity(new Intent(getActivity(),MainPage.class));
                getActivity().finish();
            }
        });

        return v;
    }

}
