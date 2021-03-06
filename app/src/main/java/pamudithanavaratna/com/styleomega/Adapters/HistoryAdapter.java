package pamudithanavaratna.com.styleomega.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pamudithanavaratna.com.styleomega.Database.OrderItem;
import pamudithanavaratna.com.styleomega.R;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.historyViewHolder> {

    private ArrayList<OrderItem> historylist;
    private Context context;

    public HistoryAdapter(ArrayList<OrderItem> historylist, Context context) {
        this.historylist = historylist;
        this.context = context;
    }

    @NonNull
    @Override
    public historyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.historysingleitem,viewGroup,false);
        historyViewHolder viewHolder = new historyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final historyViewHolder historyViewHolder, int i) {
        OrderItem o = historylist.get(i);

        final Long orderid = o.getId();
        String image = o.getImage();
        final String itemname = o.getItemname();
        String itemprice =o.getPrice();
        int numofItems =o.getTotalquantity();
        String subTotal = o.getSubtotal();

        historyViewHolder.hitemname.setText(itemname);
        historyViewHolder.hPrice.setText(itemprice);
        historyViewHolder.hsubtotal.setText(subTotal);
        historyViewHolder.hnumofItems.setText(String.valueOf(numofItems));

        Picasso.get().load(image).into(historyViewHolder.himage);

        historyViewHolder.hDeletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Delete Successful", Toast.LENGTH_SHORT).show();
                OrderItem.deleteAll(OrderItem.class,"id=?",Long.toString(orderid));
                int k = historyViewHolder.getAdapterPosition();
                historylist.remove(k);
                notifyItemRemoved(k);
                notifyItemRangeChanged(k,historylist.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return historylist.size();
    }

    public class historyViewHolder extends RecyclerView.ViewHolder{

        ImageView himage;
        TextView hitemname;
        TextView hPrice;
        TextView hsubtotal;
        TextView hnumofItems;
        Button hDeletebtn;
        RelativeLayout hrelativeLayout;

        public historyViewHolder(@NonNull View itemView) {
            super(itemView);

            himage = itemView.findViewById(R.id.historyitemimage);
            hitemname =itemView.findViewById(R.id.historyitemname);
            hPrice = itemView.findViewById(R.id.historyitemprice);
            hsubtotal = itemView.findViewById(R.id.historysubtotal);
            hnumofItems = itemView.findViewById(R.id.historyAmount);
            hDeletebtn = itemView.findViewById(R.id.historydeletebtn);
            hrelativeLayout = itemView.findViewById(R.id.historyRelative);

        }
    }
}
