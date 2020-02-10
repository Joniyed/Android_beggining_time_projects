package bd.edu.seu.buttomnavigationviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import bd.edu.seu.buttomnavigationviewdemo.fragments.Fav_list_fragment;
import bd.edu.seu.buttomnavigationviewdemo.fragments.Play_List_fragment;
import bd.edu.seu.buttomnavigationviewdemo.fragments.Player_fragment;
import bd.edu.seu.buttomnavigationviewdemo.fragments.music_list_fragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showFragments(new Player_fragment());
    }

    @Override
    protected void onStart() {
        super.onStart();

        bottomNavigationView = findViewById(R.id.buttom_nav_id);
        runTimePermission();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.music_list){
                    showFragments(new music_list_fragment());
                    //Toast.makeText(MainActivity.this,"music list is pressed",Toast.LENGTH_SHORT).show();
                    return true;
                }

                else if(menuItem.getItemId()==R.id.albums){
                    showFragments(new Play_List_fragment());
                    return true;
                }

                else if(menuItem.getItemId()==R.id.favlistId){
                    showFragments(new Fav_list_fragment());
                    return true;
                }

                else{
                    showFragments(new Player_fragment());
                    return true;
                }
            }
        });
    }

    public void showFragments(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
    }

    public void runTimePermission()
    {
        Dexter.withActivity(MainActivity.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {

            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                runTimePermission();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }
}
