package dell.example.friendzonetextonly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    String [] friends;
    int [] images = {R.drawable.nahid,R.drawable.tanim,R.drawable.akash,R.drawable.jones,
            R.drawable.joinal,R.drawable.rabby};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.GridViewId);
        friends = getResources().getStringArray(R.array.friend);

        CustomAdapter customAdapter = new CustomAdapter(this,friends,images);
        gridView.setAdapter(customAdapter);



    }
}
