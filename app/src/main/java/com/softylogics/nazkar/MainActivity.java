package com.softylogics.nazkar;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    private AppBarConfiguration mAppBarConfiguration;
    private ActionBarDrawerToggle drawerToggle;
    BottomNavigationView bottomNavi;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        checkLogin();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        setupDrawerAndToggle();

         bottomNavi = findViewById(R.id.bottomnavigation);
         bottomNavi.setItemIconTintList(null);
     bottomNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item) {

             Fragment newFrag;
             FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
             int id = item.getItemId();

             switch (item.getItemId()) {
                 case R.id.navigation_home:
                     toolbar.setTitle("Latest Ads");

                     clearBackStack();
                     return true;
                 case R.id.navigation_notification:
                     toolbar.setTitle("Notifications");
                     return true;
                     case R.id.navigation_add:
                         toolbar.setTitle("Post Ad");
                         newFrag = new adPost();

                         transaction.replace(R.id.nav_host_fragment , newFrag);
                         transaction.addToBackStack(null);
                         transaction.commit();
                         return true;
                 case R.id.navigation_category:
                     toolbar.setTitle("What we are offering");
                     newFrag = new offering();
                     transaction.replace(R.id.nav_host_fragment , newFrag);
                     transaction.addToBackStack(null);
                     transaction.commit(); return true;
                     case R.id.navigation_account:

                         newFrag = new editProfile();
                         transaction.replace(R.id.nav_host_fragment , newFrag);
                         transaction.addToBackStack(null);
                         transaction.commit();
                         return true;

             }
             return false;
         }
     });   // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(

                 R.id.nav_animals, R.id.nav_crops, R.id.nav_traders)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment newFrag;
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                int id = item.getItemId();
                switch (id) {
                    case R.id.homeicon:
                        toolbar.setTitle("Latest Ads");

                        clearBackStack();
                        break;
                    case R.id.profileicon:
                        newFrag = new editProfile();
                        transaction.replace(R.id.nav_host_fragment , newFrag);
                        transaction.addToBackStack(null);
                        transaction.commit();

                        break;
                    case R.id.advancesearch:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.notifi:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.activeads:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.inactiveads:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.logouticon:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.settingsicon:
                        newFrag = new settings();
                        transaction.add(R.id.nav_host_fragment , newFrag);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;
                    case R.id.pages:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.aboutus:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.howitworks:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.faq:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;
                    case R.id.privacypo:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        break;



                }


                return false;
            }
        });
    }

    private void checkLogin() {
        Intent intent = new Intent(MainActivity.this , first_screen.class);
        startActivity(intent);

    }

    private void setupDrawerAndToggle() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setDrawerIndicatorEnabled(true);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar.setTitle("Latest Ads");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        toolbar.setTitle("Latest Ads");
        bottomNavi.setVisibility(View.VISIBLE);
        clearBackStack();
    }
    private void clearBackStack() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
}
