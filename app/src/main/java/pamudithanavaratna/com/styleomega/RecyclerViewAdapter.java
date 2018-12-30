package pamudithanavaratna.com.styleomega;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pamudithanavaratna.com.styleomega.Database.Products;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG="Recycler view";

    /*private ArrayList<String> imagenames = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();*/
    private ArrayList<Products> productlist;
    private Context context;
/*
    public RecyclerViewAdapter(ArrayList<String> imagenames, ArrayList<String> images, Context context) {
        this.imagenames = imagenames;
        this.images = images;
        this.context = context;
    }
*/

    public RecyclerViewAdapter(ArrayList<Products> products, Context context) {
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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Products p = productlist.get(i);

        String imageUrl= p.getPicture();
        String itemname = p.getProductName();


        viewHolder.itemtext.setText(itemname);
        Picasso.get().load(imageUrl).into(viewHolder.itemimage);
    }

    @Override
    public int getItemCount() {
        return productlist.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemimage;
        TextView itemtext;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemimage = itemView.findViewById(R.id.itemimage);
            itemtext = itemView.findViewById(R.id.itemname);
            relativeLayout = itemView.findViewById(R.id.recycleRelativeLayout);
        }
    }
}
