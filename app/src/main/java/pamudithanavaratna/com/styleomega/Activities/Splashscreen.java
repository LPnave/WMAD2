package pamudithanavaratna.com.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import pamudithanavaratna.com.styleomega.Adapters.CustomSharedPreference;
import pamudithanavaratna.com.styleomega.Database.Login;
import pamudithanavaratna.com.styleomega.Database.PaymentDetails;
import pamudithanavaratna.com.styleomega.Database.Products;
import pamudithanavaratna.com.styleomega.Database.ShippingDetails;
import pamudithanavaratna.com.styleomega.Database.User;

public class Splashscreen extends AppCompatActivity {

    //private SharedPreferences preferences;
    private CustomSharedPreference preference;

    private ArrayList<Products> productsarray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       //preferences = getSharedPreferences("user",MODE_PRIVATE);
       // boolean loginstatus = preferences.getBoolean("loginstatus", false);
        boolean loginstatus = preference.getABool(getApplicationContext(),"loginstatus");


        List<Products> plistcheck= Products.listAll(Products.class);

        if(plistcheck.isEmpty()) {

            JSONObject json = null;

            try {
                json = new JSONObject(loadJSON("Products.json"));

                JSONArray wproductlist = json.getJSONArray("womenproducts");
                for (int i = 0; i < wproductlist.length(); i++) {
                    JSONObject product = wproductlist.getJSONObject(i);

                    int itemid = product.getInt("Id");
                    String itemname = product.getString("Name");
                    String itemurl = product.getString("Image");
                    String price = product.getString("Price");
                    String category = product.getString("Category");

                    productsarray.add(new Products(itemid,10,itemname, category, price, itemurl, "Women"));
                    for (Products p : productsarray) {
                        p.save();
                    }

                }
                productsarray.clear();
                JSONArray mproductlist = json.getJSONArray("menproducts");
                for (int i = 0; i < mproductlist.length(); i++) {
                    JSONObject product = mproductlist.getJSONObject(i);

                    int itemid = product.getInt("Id");
                    String itemname = product.getString("Name");
                    String itemurl = product.getString("Image");
                    String price = product.getString("Price");
                    String category = product.getString("Category");

                    productsarray.add(new Products(itemid,10 ,itemname, category, price, itemurl, "Men"));
                    for (Products p : productsarray) {
                        p.save();
                    }

                }


            } catch (JSONException e) {
                e.printStackTrace();

            }
        }


        if(!loginstatus) {
            List<User> ul = User.listAll(User.class);

            if (ul.size()==0) {

                Login testlog = new Login("pamudithanavaratna@gmail.com", "123");
                testlog.save();

                User testuser = new User("pamudithanavaratna@gmail.com", "Lahiru", "Navaratna", "0713031690", "123");
                testuser.save();

                ShippingDetails testSD = new ShippingDetails("280,Balagolla, Kengalle", "Dharshana Mw", "Kandy", "Central", 20186, testuser);
                testSD.save();

                try {
                    PaymentDetails testPD = new PaymentDetails("123546489", 549,
                            new SimpleDateFormat("dd/mm/yyyy").parse("14/03/2019"), testuser);
                    testPD.save();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }

            startActivity(new Intent(Splashscreen.this, Sign_In.class));
            finish();

        }
        else{
            startActivity(new Intent(Splashscreen.this,MainPage.class));
            finish();
        }
    }

    public String loadJSON (String filename){
        String json = null;

        try{
            InputStream is = getAssets().open(filename);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        }
        catch(IOException e){
            e.printStackTrace();
            return  null;
        }
        return json;

    }
}
