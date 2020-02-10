package dell.example.friendzonegrid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailsActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    int[] flags={R.drawable.akash,R.drawable.joinal,
            R.drawable.jones,R.drawable.nahid,
            R.drawable.rabby,R.drawable.tanim,R.drawable.tofajjol
    };

    String[] friendS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textView = findViewById(R.id.detailsTextViewId);
        imageView = findViewById(R.id.detailsImageId);

        friendS = getResources().getStringArray(R.array.FullName);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null) {
            int value =Integer.parseInt(bundle.getString("i"));
            imageView.setImageResource(flags[value]);
            textView.setText(friendS[value]);
        }


    }
}
