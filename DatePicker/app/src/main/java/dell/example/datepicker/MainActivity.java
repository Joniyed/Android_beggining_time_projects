package dell.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.showViewId);
        datePicker = findViewById(R.id.datePickerId);

        result.setText(currentDate());
    }

    public void checkDate(View view) {
        result.setText(currentDate());
    }

    String currentDate()
    {
        StringBuilder str = new StringBuilder();

        str.append(datePicker.getDayOfMonth()+"/");
        str.append(datePicker.getMonth()+1+"/");
        str.append(datePicker.getYear());
        return str.toString();
    }


}


