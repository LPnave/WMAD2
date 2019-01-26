package pamudithanavaratna.com.styleomega.Adapters;


import android.content.Context;
import android.content.SharedPreferences;

public class CustomSharedPreference {

    private static CustomSharedPreference instance;

    private CustomSharedPreference() {
    }

    public static CustomSharedPreference getInstance(){

        if(instance == null){
            instance = new CustomSharedPreference();
        }
        return instance;
    }

    public static SharedPreferences getSharedPreferences (Context context){
        return context.getSharedPreferences("user",Context.MODE_PRIVATE);
    }

    public  boolean getABool(Context context,String key){

        return getSharedPreferences(context).getBoolean(key,false);
    }

    public void putABool(Context context,String key,boolean stat){

        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(key, stat);
        editor.commit();
    }
    public String getAString(Context context,String key){

        return getSharedPreferences(context).getString(key,null);
    }

    public void putAString(Context context,String key,String value){

        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(key, value);
        editor.commit();
    }
    public Long getALong(Context context,String key){

        return getSharedPreferences(context).getLong(key,0);
    }

    public void putALong(Context context,String key,Long value){

        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putLong(key, value);
        editor.commit();
    }


}
