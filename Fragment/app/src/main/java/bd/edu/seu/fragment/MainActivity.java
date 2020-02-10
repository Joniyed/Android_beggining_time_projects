package bd.edu.seu.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import bd.edu.seu.fragment.jbFragment.JbFragment;
import bd.edu.seu.fragment.snFragment.SnFragment;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);

        String[] list = {"JB","SN"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment fragment;
                if(i==0){
                    fragment = new JbFragment();
//                    FragmentManager fragmentManager = getFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.fragmentId,fragment);
//                    fragmentTransaction.commit();
                    //Objects.requireNonNull(getFragmentManager().beginTransaction(R.id.fragmentId,fragment)).commit();
                    getFragmentManager().beginTransaction().replace(R.id.fragmentId,fragment).commit();
                }
                else if(i==1){
                    fragment = new SnFragment();
//                    FragmentManager fragmentManager = getFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.fragmentId,fragment);
//                    fragmentTransaction.commit();
                    getFragmentManager().beginTransaction().replace(R.id.fragmentId,fragment).commit();
                }
            }
        });

    }
}
