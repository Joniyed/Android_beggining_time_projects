package dell.example.checkboxradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private CheckBox cse,bba;
    private TextView checkboxResult;
    private RadioGroup radioGroup;
    private RadioButton genderButton;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private Switch aSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cse = findViewById(R.id.cseid);
        bba = findViewById(R.id.bbaid);
        checkboxResult = findViewById(R.id.checkboxResultId);

        radioGroup = findViewById(R.id.radioGroupId);

        ratingBar = findViewById(R.id.ratingBarId);

        seekBar = findViewById(R.id.seekBarId);

        aSwitch = findViewById(R.id.switchId);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                checkboxResult.setText("Rating : "+v);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                checkboxResult.setText("Volume : "+i+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"StartTrackingTouch",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"StopTrackingTouch",Toast.LENGTH_SHORT).show();
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Toast.makeText(MainActivity.this,"On",Toast.LENGTH_SHORT).show();
                    checkboxResult.setText("Bluetooth is On");
                }
                else{
                    Toast.makeText(MainActivity.this,"Off",Toast.LENGTH_SHORT).show();
                    checkboxResult.setText("Bluetooth is Off");
                }
            }
        });

    }

    public void showCheckBox(View view)
    {
        StringBuilder str = new StringBuilder();
        if(cse.isChecked())
        {
            String value = cse.getText().toString()+" is selected"+"\n";
            str.append(value);
        }
        if(bba.isChecked())
        {
            String value = bba.getText().toString()+" is selected"+"\n";
            str.append(value);
        }
        checkboxResult.setText(str);
    }

    @SuppressLint("SetTextI18n")
    public void showradio(View view) {

        genderButton = findViewById(radioGroup.getCheckedRadioButtonId());
        String value = " is selected";
        checkboxResult.setText(genderButton.getText().toString()+value);
    }
}
