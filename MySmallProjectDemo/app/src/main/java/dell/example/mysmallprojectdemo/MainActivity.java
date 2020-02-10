package dell.example.mysmallprojectdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button Name,Batch,Dept,student;
    private TextView studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.nameId);
        Batch = findViewById(R.id.batchId);
        Dept = findViewById(R.id.deptId);
        student = findViewById(R.id.studentnameId);

        studentName = findViewById(R.id.studentTextViewId);


        Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = Name.getText().toString();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",value);
                startActivity(intent);
            }
        });

        Batch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = Batch.getText().toString();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",value);
                startActivity(intent);
            }
        });

        Dept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = Dept.getText().toString();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",value);
                startActivity(intent);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StudentName.class);
                startActivityForResult(intent,1);

            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

        alertDialog.setTitle("alert:???");
        alertDialog.setMessage("Do you want to exit ??");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        alertDialog.setCancelable(false);
        AlertDialog alertDialog1 = alertDialog.create();
        alertDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data!=null) {
            if(requestCode==1) {
                String value = data.getStringExtra("name");
                studentName.setText(value);
            }

        }
    }
}
