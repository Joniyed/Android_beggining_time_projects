package bd.edu.seu.dbdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bd.edu.seu.dbdemo.adapter.RecyclerViewAdapter;
import bd.edu.seu.dbdemo.data.MyDbHandler;
import bd.edu.seu.dbdemo.model.Contact;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //textView = findViewById(R.id.textViewId);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewId);

        //create a dbhelper object
        MyDbHandler db = new MyDbHandler(this);

        //create contact object and add contact
        Contact contact = new Contact();
        int i=db.totalContact();
        if(i<=0) {
            contact.setName("joniyed");
            contact.setPhone_number("01688820107");
            db.addContact(contact);

            contact.setName("Nahid");
            contact.setPhone_number("01624756285");
            db.addContact(contact);

            contact.setName("Arif");
            contact.setPhone_number("01857932971");
            db.addContact(contact);

            contact.setName("Juwel");
            contact.setPhone_number("01770014777");
            db.addContact(contact);

            contact.setName("Joinal");
            contact.setPhone_number("01784579806");
            db.addContact(contact);

            contact.setName("Tanim");
            contact.setPhone_number("01621043101");
            db.addContact(contact);

            contact.setName("Akash");
            contact.setPhone_number("01621043077");
            db.addContact(contact);

            contact.setName("Rabby");
            contact.setPhone_number("01620221274");
            db.addContact(contact);
        }


        //update contact
//        contact.setName("jb");
//        contact.setPhone_number("90897982");
//        db.updateContac("",contact);


        //delete contact from the database
        //db.deleteContact("Sn");


        //reade all the contact from database
        List<Contact> allcontacts = db.getAllcontacts();
        String str = "";
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> phoneList = new ArrayList<>();
        for(Contact x : allcontacts){
           nameList.add(x.getName());
           phoneList.add(x.getPhone_number());
        }
        RecyclerViewAdapter adapter= new RecyclerViewAdapter(this,nameList,phoneList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
