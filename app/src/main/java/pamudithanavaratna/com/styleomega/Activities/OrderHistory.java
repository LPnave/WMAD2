package pamudithanavaratna.com.styleomega.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pamudithanavaratna.com.styleomega.Adapters.CustomSharedPreference;
import pamudithanavaratna.com.styleomega.Database.OrderItem;
import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.Adapters.HistoryAdapter;
import pamudithanavaratna.com.styleomega.R;

public class OrderHistory extends AppCompatActivity {

    private ArrayList<OrderItem> historylist;
    private RecyclerView historyrecycleview;
    private HistoryAdapter historyAdapter;


    private CustomSharedPreference preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        preference = CustomSharedPreference.getInstance();
        historylist= new ArrayList<>();

        long userid = preference.getALong(getApplicationContext(),"userid");

        User loggeduser = User.findById(User.class,userid);
        List<OrderItem> ol=OrderItem.listAll(OrderItem.class);

        if(ol!=null) {
            for (OrderItem o : ol) {
                //User user = o.getUser();
                if (o.getUser().getEmail().equals(loggeduser.getEmail())&& o.getStatus().equals("Paid")) {
                    historylist.add(o);

                }

            }
        }else{
            Toast.makeText(getApplicationContext(),"History empty",Toast.LENGTH_SHORT).show();
        }


        historyrecycleview = findViewById(R.id.historyrecyclerview);
        historyrecycleview.setHasFixedSize(true);
        historyrecycleview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        historyAdapter = new HistoryAdapter(historylist,getApplicationContext());

        historyrecycleview.setAdapter(historyAdapter);

    }
}
