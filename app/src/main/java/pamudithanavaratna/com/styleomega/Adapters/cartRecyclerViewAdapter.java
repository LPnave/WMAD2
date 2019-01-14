package pamudithanavaratna.com.styleomega.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class cartRecyclerViewAdapter extends RecyclerView.Adapter<cartRecyclerViewAdapter.cartViewHolder> {

    private ArrayList<OrderItem> orderlist;
    private Context context;


    public cartRecyclerViewAdapter(ArrayList<OrderItem> orderlist, Context context) {
        this.orderlist = orderlist;
        this.context = context;
    }

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cartlist,viewGroup,false);
        cartViewHolder holder = new cartViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final cartViewHolder cartViewHolder, int i) {
        OrderItem o = orderlist.get(i);

        final Long orderid = o.getId();
        String image = o.getImage();
        final String itemname = o.getItemname();
        String itemprice =o.getPrice();
        int numofItems =o.getNumberOfItems();
        String subTotal = o.getSubtotal();

        cartViewHolder.cartitemPrice.setText(itemprice);
        cartViewHolder.cartitemname.setText(itemname);
        cartViewHolder.subtotal.setText(subTotal);
        cartViewHolder.numofItems.setText(Integer.toString(numofItems));

        Picasso.get().load(image).into(cartViewHolder.cartimage);

        cartViewHolder.paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(context)
                        .setTitle("Confirm Payment for this Item?")
                        .setMessage("The Account you have in your profile wil be used")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                OrderItem oi = (OrderItem.find(OrderItem.class,"id=?", orderid.toString()).get(0));
                                oi.setStatus("Paid");
                                oi.save();
                                int j = cartViewHolder.getAdapterPosition();
                                orderlist.remove(j);
                                notifyItemRemoved(j);
                                notifyItemRangeChanged(j,orderlist.size());
                                Toast.makeText(context,"payment Successful" + itemname, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();


            }
        });

        cartViewHolder.Deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(context)
                        .setTitle("Remove from cart?")
                        .setMessage("Are you sure you want to delete the following listing?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int j = cartViewHolder.getAdapterPosition();
                                OrderItem.deleteAll(OrderItem.class,"id=?",Long.toString(orderid));

                                orderlist.remove(j);
                                notifyItemRemoved(j);
                                notifyItemRangeChanged(j,orderlist.size());
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();


            }
        });


    }

    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    public class cartViewHolder extends RecyclerView.ViewHolder {

        ImageView cartimage;
        TextView cartitemname;
        TextView cartitemPrice;
        TextView subtotal;
        TextView numofItems;
        Button paybtn;
        Button Deletebtn;
        RelativeLayout relativeLayout;

        public cartViewHolder (View cartview){
            super(cartview);

            cartimage= cartview.findViewById(R.id.cartitemimage);
            cartitemname= cartview.findViewById(R.id.cartitemname);
            cartitemPrice = cartview.findViewById(R.id.cartitemprice);
            subtotal = cartview.findViewById(R.id.subtotal);
            numofItems = cartview.findViewById(R.id.viewnumberofitems);
            relativeLayout = cartview.findViewById(R.id.recyclecartRelativeLayout);
            paybtn = cartview.findViewById(R.id.paybtn);
            Deletebtn = cartview.findViewById(R.id.deletebtn);


        }
    }
}



