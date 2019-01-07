package pamudithanavaratna.com.styleomega;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    Context context;

    private final String[] values;
    private final int[] images;
    View myview;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, String[] values, int[] images) {
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    public String getItemName(int i){
       return values[i];

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view==null){

            myview = new View(context);
            myview = layoutInflater.inflate(R.layout.single_cat_item,null);
            ImageView imageView = (ImageView) myview.findViewById(R.id.catImage);
            TextView textView = (TextView) myview.findViewById(R.id.catText);
            imageView.setImageResource(images[i]);
            textView.setText(values[i]);

        }else{
            myview =(View) view;
        }

        return myview;
    }
}
