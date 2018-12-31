package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pamudithanavaratna.com.styleomega.Activities.Cart;
import pamudithanavaratna.com.styleomega.Activities.MainPage;
import pamudithanavaratna.com.styleomega.Database.OrderItem;
import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.R;
import pamudithanavaratna.com.styleomega.cartRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private ArrayList<OrderItem> orderlist;
    private RecyclerView cartrecycleview;
    private cartRecyclerViewAdapter cartRecyclerViewAdapter;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        orderlist= new ArrayList<>();

        Cart cartactivity = (Cart)getActivity();
        User loggeduser = cartactivity.getLoggedin();


        List<OrderItem>ol=OrderItem.listAll(OrderItem.class);
        if(ol!=null) {
            for (OrderItem o : ol) {
                if (o.getUser().getEmail().equals(loggeduser.getEmail())) {
                    orderlist.add(o);

                }

            }
        }else{
            Toast.makeText(getContext(),"Cart empty",Toast.LENGTH_SHORT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_cart,container,false);

        cartrecycleview =v.findViewById(R.id.cartrecyclerview);
        cartrecycleview.setHasFixedSize(true);
        cartrecycleview.setLayoutManager(new LinearLayoutManager(getContext()));

        cartRecyclerViewAdapter = new cartRecyclerViewAdapter(orderlist,getContext());
        cartrecycleview.setAdapter(cartRecyclerViewAdapter);



        return v;
    }

}
