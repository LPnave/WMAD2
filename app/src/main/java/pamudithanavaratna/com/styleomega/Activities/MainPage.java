package pamudithanavaratna.com.styleomega.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pamudithanavaratna.com.styleomega.Database.Products;
import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.Fragments.ItemsPageFragment;
import pamudithanavaratna.com.styleomega.Fragments.MainFragment;
import pamudithanavaratna.com.styleomega.Fragments.tab1;
import pamudithanavaratna.com.styleomega.Fragments.tab2;
import pamudithanavaratna.com.styleomega.R;

public class  MainPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public static FragmentManager fragmentManager;
    String useremail;
    String username;
    Bundle bundle = new Bundle();
    private static ArrayList<String> resultlist= new ArrayList<>();

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);



        if(resultlist!=null){

            resultlist.clear();
        }

        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView)findViewById(R.id.searchbar);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerview = navigationView.getHeaderView(0);
        TextView headeremail = headerview.findViewById(R.id.textViewheaderemail);
        headeremail.setText(useremail);
        TextView headername = headerview.findViewById(R.id.textViewheadername);
        headername.setText(username);


        //searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) this);
        //searchView.setQueryHint("Search for products");

        navigationView.setNavigationItemSelectedListener(this);

        preferences = getSharedPreferences("user", MODE_PRIVATE);

        long userid = preferences.getLong("userid",0);

        User user= User.findById(User.class,userid);

        useremail = user.email;
        username = user.Fname + " " + user.Lname;

        bundle.putString("useremail",useremail);



            fragmentManager = getSupportFragmentManager();
            if (findViewById(R.id.MainContainer) != null) {
                if (savedInstanceState != null) {
                    return;
                }
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MainFragment mainFragment = new MainFragment();
                mainFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.MainContainer, mainFragment);
                fragmentTransaction.commit();

            }

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
            ItemsPageFragment IPF = new ItemsPageFragment();
            IPF.setArguments(bundle);

            if(findViewById(R.id.MainContainer)!=null) {
                //to avoid overlapping
               /* if (savedInstanceState != null) {
                    return;
                }*/

                MainPage.fragmentManager.beginTransaction().replace(R.id.MainContainer,
                        IPF, null).addToBackStack("results").commit();
            }
        }




    }

    private void doMySearch(String query) {
        List<Products> searchlist = Products.listAll(Products.class);
        for (Products p : searchlist){
            String[] querykeywords = query.split("\\s+");
            String[] keywords = p.getProductName().split("\\s+");

            for(String s : keywords) {
                for(String j : querykeywords) {
                    if (s.equalsIgnoreCase(j)) {
                        if(resultlist==null || !resultlist.contains(p.getId().toString())) {

                            resultlist.add(p.getId().toString());

                        }
                    }
                }
            }
        }

        bundle.putStringArrayList("resultlist", resultlist);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_page, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Bundle bundle = new Bundle();
        bundle.putString("useremail",useremail);
        //bundle.putSerializable("loggeduser",loggedin);
        Intent cartintent = new Intent(MainPage.this,Cart.class);
        cartintent.putExtras(bundle);
        startActivity(cartintent);

        Toast.makeText(this,"Loading cart",Toast.LENGTH_SHORT);
       /* int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            startActivity( new Intent( MainPage.this,Profile.class));
        } else if (id == R.id.logout) {
            preferences = getSharedPreferences("user",MODE_PRIVATE);
            editor = preferences.edit();
            editor.putBoolean("loginstatus", false);
            editor.commit();
            startActivity(new Intent(MainPage.this, Sign_In.class));

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}

