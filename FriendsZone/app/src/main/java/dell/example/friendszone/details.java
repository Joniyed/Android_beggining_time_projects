package dell.example.friendszone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class details extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.imageId);
        textView = findViewById(R.id.textId);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            int i = Integer.parseInt(Objects.requireNonNull(bundle.getString("name")));
            switch (i)
            {
                case 0:
                    imageView.setImageResource(R.drawable.one);
                    textView.setText(R.string.jb);
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.one);
                    textView.setText(R.string.tk);
                    break;

            }
        }

    }
}
