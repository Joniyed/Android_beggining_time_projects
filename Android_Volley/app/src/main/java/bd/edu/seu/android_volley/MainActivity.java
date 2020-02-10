package bd.edu.seu.android_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import bd.edu.seu.android_volley.Constant.MyConstant;
import bd.edu.seu.android_volley.util.CommonConstant;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView = findViewById(R.id.myTextView);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void callServer(){
        try {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading,,,");
            progressDialog.setCancelable(false);

            RequestQueue requestQueue = Volley.newRequestQueue(this);
        }catch (Exception e)
        {
            Log.d("jb",e.toString());
        }
    }
}
