package pamudithanavaratna.com.styleomega.Adapters;


import android.content.Context;
import android.content.SharedPreferences;

public class CustomSharedPreference {
    //private static Context context;
    //private SharedPreferences preferences;


    public CustomSharedPreference() {
    }

    public static SharedPreferences getSharedPreferences (Context context){
        return context.getSharedPreferences("user",Context.MODE_PRIVATE);
    }

    public static  boolean getABool(Context context,String key){

        return getSharedPreferences(context).getBoolean(key,false);
    }

    public static void putABool(Context context,String key,boolean stat){

        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(key, stat);
        editor.commit();
    }
    public static String getAString(Context context,String key){

        return getSharedPreferences(context).getString(key,null);
    }

    public static void putAString(Context context,String key,String value){

        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(key, value);
        editor.commit();
    }
    public static Long getALong(Context context,String key){

        return getSharedPreferences(context).getLong(key,0);
    }

    public static void putALong(Context context,String key,Long value){

        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putLong(key, value);
        editor.commit();
    }


}
