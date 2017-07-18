package com.cerezaconsulting.coreproject.presentation.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cerezaconsulting.coreproject.R;
import com.cerezaconsulting.coreproject.core.BaseActivity;
import com.cerezaconsulting.coreproject.data.local.SessionManager;
import com.cerezaconsulting.coreproject.data.model.UserEntity;
import com.cerezaconsulting.coreproject.presentation.fragments.InputPayFragment;
import com.cerezaconsulting.coreproject.presentation.fragments.SelectCategoryFragment;

import java.util.ArrayList;
import java.util.List;


public class InitActivity extends BaseActivity {

    SessionManager mSessionManager;
    private Toolbar toolbar;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mSessionManager = new SessionManager(this);
        /**
         *Setup the DrawerLayout and NavigationView
         */
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.layout_content_frame);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View activityView = layoutInflater.inflate(R.layout.layout_init, null, false);


        /**
         * Setup click events on the Navigation View Items.
         */
        frameLayout.addView(activityView);
        viewPager = (ViewPager) activityView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Empecemos...");


    }

    public void activeBack(boolean active) {
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(active);
        ab.setDisplayShowHomeEnabled(active);
        if (active){
            toolbar.setTitle("Empecemos...");
        }else{
            toolbar.setTitle("Elige");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_next, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btn_next:
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new InputPayFragment(), "Pendientes");
        adapter.addFragment(new SelectCategoryFragment(), "Realizadas");
        // adapter.addFragment(new DateExpiredProfileFragment(), "Canceladas");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        menuItem.setChecked(false);
                        menuItem.setCheckable(false);


                        switch (menuItem.getItemId()) {
                            case R.id.nav_connect:
                             /*  Intent intent_connect = new Intent(getBaseContext(), ProfileActivity.class);
                                startActivityForResult(intent_connect,200);
                */
                                break;
                            case R.id.nav_signout:

                                CloseSession();

                                break;

                            default:

                                break;
                        }
                        menuItem.setChecked(false);
                        //  mDrawer.closeDrawers();
                        return true;
                    }

                });
    }


    private void CloseSession() {
        mSessionManager.closeSession();
        // newActivityClearPreview(this,null,LoadActivity.class);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

       /* if (Activity.RESULT_OK == resultCode)
            if (200 == requestCode) {
                initHeader();

            }*/


    }

    @Override
    public void onBackPressed() {
    }


}
