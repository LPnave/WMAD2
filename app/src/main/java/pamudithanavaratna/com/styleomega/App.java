package pamudithanavaratna.com.styleomega;


import android.content.Context;
import android.content.SharedPreferences;

public class App extends com.orm.SugarApp {
    private static Context context;
    private SharedPreferences preferences;


    public App() {
    }


    public SharedPreferences getSharedPreferences (){
        return context.getSharedPreferences("APP_DATA", Context.MODE_PRIVATE);
    }

    public boolean getABool(String key){

        return getSharedPreferences().getBoolean(key,false);
    }

    public void putABool(String key,boolean stat){

        final SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(key, stat);
        editor.commit();
    }

    private static Context getContext(){

        return context;
    }

    protected boolean callSuper() {
        return true;
    }

    @Override
    public void onCreate() {
        if(callSuper()){
            super.onCreate();
        }

        context = getApplicationContext();
        preferences = getSharedPreferences();
    }

    @Override
    public void onTerminate() {
        if(callSuper()){
            super.onTerminate();
        }
    }
}
