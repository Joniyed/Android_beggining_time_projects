package com.example.smartdeviceappdevelopementfall2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smartdeviceappdevelopementfall2019.fragments.GoogleMapFragment;
import com.example.smartdeviceappdevelopementfall2019.fragments.NetworkConnectionFragment;
import com.example.smartdeviceappdevelopementfall2019.fragments.UserListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Button buttonForMap, buttonForAPI, buttonForUserList;
    BottomNavigationView bottomNavigationView;
    Fragment default_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE},999);
        }

        // default fragment
        showFragment(new GoogleMapFragment());
    }

    @Override
    protected void onStart() {
        super.onStart();
        default_frag = new GoogleMapFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,default_frag).commit();

        /*
        buttonForUserList = findViewById(R.id.button_user_list);
        buttonForAPI = findViewById(R.id.button_api);
        buttonForMap = findViewById(R.id.button_map);

        buttonForUserList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment userListFragment = new UserListFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainFrame,userListFragment);
                transaction.commit();
            }
        });

        buttonForAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment userListFragment = new NetworkConnectionFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainFrame,userListFragment);
                transaction.commit();
            }
        });

        buttonForMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment userListFragment = new GoogleMapFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainFrame,userListFragment);
                transaction.commit();
            }
        });

        */

        bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.googleMapMenu){
                    showFragment(new GoogleMapFragment());
                    bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    return true;
                }
                else if(menuItem.getItemId()==R.id.userListMenu){
                    showFragment(new UserListFragment());
                    bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    return true;
                }
                else if(menuItem.getItemId()==R.id.apiMenu){
                    showFragment(new NetworkConnectionFragment());
                    bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    return true;
                }

                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_navigation_drawer_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.googleMapMenu){
            showFragment(new GoogleMapFragment());
            bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        if(item.getItemId()==R.id.userListMenu){
            showFragment(new UserListFragment());
            bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        if(item.getItemId()==R.id.apiMenu){
            showFragment(new NetworkConnectionFragment());
            bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }


        return super.onOptionsItemSelected(item);
    }


    public void showFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame,fragment);
        transaction.commit();
    }

    public void generetData(){

    }
}
