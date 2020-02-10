package dell.example.friendzonegrid;

import
        androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    int[] flags={R.drawable.akash,R.drawable.joinal,
                R.drawable.jones,R.drawable.nahid,
                R.drawable.rabby,R.drawable.tanim,R.drawable.tofajjol
            };

    String[] friendS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friendS = getResources().getStringArray(R.array.FriedsList);
        gridView = findViewById(R.id.GridViewId);

        CustomAdapter customAdapter = new CustomAdapter(this,friendS,flags);
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,detailsActivity.class);
                String value = i+"";
                intent.putExtra("i",value);
                startActivity(intent);
            }
        });

    }
}
