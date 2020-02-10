package bd.edu.seu.json_parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    BufferedReader bufferedReader=null;
    StringBuffer finalBuffer=new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewId);

        jsonTask jtask = new jsonTask();
        jtask.execute();
    }

    public class jsonTask extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {

            HttpURLConnection httpURLConnection = null;
            try{
                URL url = new URL("https://api.myjson.com/bins/yrdnc");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";

                while ((line = bufferedReader.readLine())!=null){
                    stringBuffer.append(line);
                }

                String file = stringBuffer.toString();

                JSONObject jsonObject = new JSONObject(file);
                JSONArray jsonArray = jsonObject.getJSONArray("studentinfo");
                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject arrayObject = jsonArray.getJSONObject(i);
                    finalBuffer.append(arrayObject.getString("name")+" "+
                            arrayObject.getString("age")+" "+
                            arrayObject.getString("description")+"\n"
                    );
                }
                return finalBuffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                httpURLConnection.disconnect();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
        }
    }
}
