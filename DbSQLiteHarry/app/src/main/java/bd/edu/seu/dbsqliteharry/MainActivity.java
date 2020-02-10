package bd.edu.seu.dbsqliteharry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bd.edu.seu.dbsqliteharry.data.MyDbHandler;
import bd.edu.seu.dbsqliteharry.model.Contact;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView = findViewById(R.id.resultID);
        listView = findViewById(R.id.listViewId);

        MyDbHandler db = new MyDbHandler(this);

        Contact contact = new Contact();
        contact.setName("jb");
        contact.setPhoneNumber("016***");
        //db.addContact(contact);
        db.deleteContact("jb");


        List<Contact> contactList = new ArrayList<>();
        ArrayList<String> allContacts = new ArrayList<>();
        contactList = db.getAllContacts();
        String str = "";
        for(Contact contact1: contactList){
            str = contact1.getId()+" : "+ contact1.getName()+" - "+contact1.getPhoneNumber()+"\n";
            allContacts.add(str);
            //textView.setText(str);
        }
        ArrayAdapter<String> contacts = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,allContacts);
        listView.setAdapter(contacts);
    }
}
