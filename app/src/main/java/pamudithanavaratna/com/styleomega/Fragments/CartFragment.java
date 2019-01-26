package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pamudithanavaratna.com.styleomega.Adapters.CustomSharedPreference;
import pamudithanavaratna.com.styleomega.Database.OrderItem;
import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.R;
import pamudithanavaratna.com.styleomega.Adapters.cartRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private ArrayList<OrderItem> orderlist;
    private RecyclerView cartrecycleview;
    private cartRecyclerViewAdapter cartRecyclerViewAdapter;

    //private SharedPreferences preferences;
    private CustomSharedPreference preference;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preference = CustomSharedPreference.getInstance();
        orderlist= new ArrayList<>();

        long userid = preference.getALong(getContext(),"userid");

        User loggeduser = User.findById(User.class,userid);

        List<OrderItem>ol=OrderItem.listAll(OrderItem.class);
        if(ol.size()>0) {
            for (OrderItem o : ol) {
                //User user = o.getUser();
                if (o.getUser().getEmail().equals(loggeduser.getEmail())&& o.getStatus().equalsIgnoreCase("Saved")) {
                    orderlist.add(o);
                }
            }
        }else{
            Toast.makeText(getContext(),"Cart empty",Toast.LENGTH_SHORT).show();
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
