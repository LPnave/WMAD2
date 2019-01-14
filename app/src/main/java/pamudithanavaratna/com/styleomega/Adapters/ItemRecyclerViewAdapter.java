package pamudithanavaratna.com.styleomega.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import pamudithanavaratna.com.styleomega.Activities.MainPage;
import pamudithanavaratna.com.styleomega.Database.Products;
import pamudithanavaratna.com.styleomega.Fragments.ItemDescriptionFragment;
import pamudithanavaratna.com.styleomega.R;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {

    private static final String TAG="Recycler view";


    private List<Products> productlist;
    private Context context;


    public ItemRecyclerViewAdapter(List<Products> products, Context context) {
        this.productlist = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem,viewGroup,false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final Products p = productlist.get(i);

        final long itemid = p.getId();
        final String imageUrl= p.getPicture();
        final String itemname = p.getProductName();
        final String Price = p.getPrice();

        viewHolder.itemtext.setText(itemname);
        viewHolder.itemPrice.setText(Price);
        Picasso.get().load(imageUrl).into(viewHolder.itemimage);

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle bundle = new Bundle();
                bundle.putLong("itemID",itemid);
                ItemDescriptionFragment IDF = new ItemDescriptionFragment();
                IDF.setArguments(bundle);

                MainPage.fragmentManager.beginTransaction().replace(R.id.MainContainer,
                        IDF,null).addToBackStack("itemspage").commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productlist.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemimage;
        TextView itemtext;
        TextView itemPrice;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemimage = itemView.findViewById(R.id.itemimage);
            itemtext = itemView.findViewById(R.id.itemname);
            itemPrice = itemView.findViewById(R.id.itemprice);
            relativeLayout = itemView.findViewById(R.id.recycleRelativeLayout);
        }
    }
}
