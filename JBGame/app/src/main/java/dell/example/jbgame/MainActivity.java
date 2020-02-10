package dell.example.jbgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button CheckButton;
    private EditText editText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckButton = findViewById(R.id.CheckButton);
        editText = findViewById(R.id.editTextId);
        resultTextView = findViewById(R.id.resultTextViewId);

        CheckButton.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        String guess = editText.getText().toString();
        if(guess.isEmpty())
        {
            errorMsg();
        }
        else{
            int guessNumber = Integer.parseInt(guess);
            if(guessNumber>0 && guessNumber<=10)
            {
                Random ran = new Random();
                int randomNum = ran.nextInt(10)+1;
                if(randomNum == guessNumber)
                {
                    resultTextView.setText(R.string.won);
                }
                else
                {
                    resultTextView.setText("Sorry! you loss the game...\n"+"Number was: " +randomNum);
                }
            }
            else{
                errorMsg();
            }

        }

    }
    @SuppressLint("SetTextI18n")
    void errorMsg(){
        editText.setText("Enter a valid input");
        editText.requestFocus();
    }
}
