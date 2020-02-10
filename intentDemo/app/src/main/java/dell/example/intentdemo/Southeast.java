package dell.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Southeast extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southeast);

        textView = findViewById(R.id.seu);

        StringBuilder stringBuilder = new StringBuilder();

        String value = textView.getText().toString();

        stringBuilder.append(value).append("\n");

        Bundle bundle = getIntent().getExtras();

        assert bundle != null;
        if(!bundle.isEmpty())
        {
            value = bundle.getString("tag");
            stringBuilder.append(value);

            textView.setText(stringBuilder.toString());
        }

    }
}
