package dell.example.mysmallprojectdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentName extends AppCompatActivity {

    private Button saveButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_name);

        saveButton = findViewById(R.id.saveButtonId);
        editText = findViewById(R.id.editTextId);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentName.this,MainActivity.class);

                String value = editText.getText().toString();
                intent.putExtra("name",value);
                setResult(1,intent);
                finish();
            }
        });
    }
}
