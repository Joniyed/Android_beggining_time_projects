package dell.example.mytextviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private Button show,hide;
    private TextView field,result,checkBoxResult;
    private EditText editText1,editText2;
    private ImageView imageView;

    private CheckBox cse,eee,bba;
    private LayoutInflater inflater;
    private LayoutInflater inflater1;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        show = findViewById(R.id.show);
        hide = findViewById(R.id.hide);
        field = findViewById(R.id.field);

        editText1 = findViewById(R.id.number1);
        editText2 = findViewById(R.id.number2);

        result = findViewById(R.id.result);
        checkBoxResult = findViewById(R.id.checkboxResultId);

        cse = findViewById(R.id.CSEid);
        eee = findViewById(R.id.EEEid);
        bba = findViewById(R.id.BBAid);


    }
    public void show_msg(View view)
    {
        if(view.getId()==R.id.show) {
            field.setText(R.string.text);
            Toast toast = Toast.makeText(MainActivity.this, R.string.toastclick,Toast.LENGTH_SHORT);
            toast.show();
            Log.d("tag","Show button is clicked");
        }
    }

    public void hide_msg(View v) {
        if (v.getId() == R.id.hide)
        {
            field.setText("");
            Toast t = Toast.makeText(MainActivity.this,R.string.tosthide,Toast.LENGTH_SHORT);
            t.show();
            Log.d("tag","Hide button is clicked");
        }
    }

    @SuppressLint("SetTextI18n")
    public void do_math(View view)
    {
        try{
            double num1 = Double.parseDouble(editText1.getText().toString());
            double num2 = Double.parseDouble(editText2.getText().toString());
            double z;

            if(view.getId()==R.id.plus)
            {
                z = num1 + num2;
                result.setText("ADD result: "+z);
                Toast.makeText(MainActivity.this,R.string.plus,Toast.LENGTH_SHORT).show();
            }
            if(view.getId()==R.id.minus)
            {
                z = num1 - num2;
                result.setText("Minus Result: "+z);
                Toast.makeText(MainActivity.this,R.string.minus,Toast.LENGTH_SHORT).show();
            }
            if(view.getId()==R.id.clear)
            {
                editText1.setText("");
                editText2.setText("");
                result.setText("");
            }

        }catch (Exception e)
        {
            Toast.makeText(MainActivity.this,"Please Enter number",Toast.LENGTH_SHORT).show();
            Log.d("Error",String.valueOf(e));
        }
    }

    public void checkboxShow(View view) {
        StringBuilder str = new StringBuilder();

        if(cse.isChecked())
        {
            String value = cse.getText().toString()+" is selected"+"\n";
            str.append(value);
        }
        if(eee.isChecked())
        {
            String value = eee.getText().toString()+" is selected"+"\n";
            str.append(value);
        }
        if(bba.isChecked())
        {
            String value = bba.getText().toString()+"is selected"+"\n";
            str.append(value);
        }
        checkBoxResult.setText(str);
    }
}

