package dell.example.mysmallprojectdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.resultId);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {

            String value = bundle.getString("name");

            if(value.equals("Name"))
            {
                textView.setText(R.string.seu);
            }
            else if(value.equals("Batch"))
            {
                textView.setText(R.string.th);
            }
            else {
                textView.setText(R.string.cse);
            }
        }
    }
}
