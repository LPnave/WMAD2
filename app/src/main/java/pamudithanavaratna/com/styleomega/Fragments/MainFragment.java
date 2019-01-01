package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import pamudithanavaratna.com.styleomega.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {



    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main,container,false);

        sectionsPageAdapter = new SectionsPageAdapter(getChildFragmentManager());
        //sectionsPageAdapter = new SectionsPageAdapter(getActivity().getSupportFragmentManager());
        viewPager = (ViewPager)v.findViewById(R.id.pager);
        setupViewPager(viewPager);

        TabLayout tabLayout = v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        return v;
    }

    private void setupViewPager(ViewPager viewPager){

        SectionsPageAdapter sectionsPageAdapter = new SectionsPageAdapter(getChildFragmentManager());
        sectionsPageAdapter.addFragment(new tab1(),"Women");
        sectionsPageAdapter.addFragment(new tab2(),"Men");
        viewPager.setAdapter(sectionsPageAdapter);

    }

    public static class SectionsPageAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public void addFragment(Fragment fragment, String title){

            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        public SectionsPageAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);

        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);

        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
