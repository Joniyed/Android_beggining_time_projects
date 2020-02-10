package dell.example.hello_world;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button show;
    private Button hide;
    private TextView myPara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView department = findViewById(R.id.myTextView);
        TextView batch = findViewById(R.id.myTextView1);

        department.setText(R.string.dept);
        batch.setText(R.string.b);


        show = findViewById(R.id.mybutton);
        hide = findViewById(R.id.hide);
        myPara = findViewById(R.id.mypara);
    }

    public void show_msg(View view)
    {
        if(view.getId()==R.id.mybutton)
        {
            myPara.setText(R.string.myself);
            Toast t = Toast.makeText(MainActivity.this,R.string.ShowButtonClicked,Toast.LENGTH_SHORT);
            t.show();
        }
    }
    public void hide_msg(View view)
    {
        if(view.getId()==R.id.hide)
        {
            myPara.setText("");
            Toast t = Toast.makeText(MainActivity.this,R.string.HideButtonClicked,Toast.LENGTH_SHORT);
            t.show();
        }
    }
}