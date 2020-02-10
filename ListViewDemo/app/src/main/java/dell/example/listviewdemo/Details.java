package dell.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Details extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        textView = findViewById(R.id.detailsTextViewId);
        imageView = findViewById(R.id.imageId);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
        {
            int i=10;
            String value = bundle.getString("name");
            if(value != null) {
                i = Integer.parseInt(value);
            }
        }
    }
}
