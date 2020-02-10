package bd.edu.seu.myfragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import bd.edu.seu.myfragmentexample.imageFragment.ImageFragment;
import bd.edu.seu.myfragmentexample.personFragment.PersonFragment;
import bd.edu.seu.myfragmentexample.phoneFragment.PhoneFragment;

public class MainActivity extends AppCompatActivity {
    Button buttonPerson,buttonImage,buttonPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPerson = findViewById(R.id.button1);
        buttonImage  = findViewById(R.id.button2);
        buttonPhone  = findViewById(R.id.button3);

        buttonPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new PhoneFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragmentId,fragment).commit();
            }
        });

        buttonPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new PersonFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragmentId,fragment).commit();
            }
        });

        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ImageFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragmentId,fragment).commit();
            }
        });
    }
}
