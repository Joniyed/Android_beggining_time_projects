package bd.edu.seu.dbsqliteharry.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import bd.edu.seu.dbsqliteharry.model.Contact;
import bd.edu.seu.dbsqliteharry.params.Params;

public class MyDbHandler extends SQLiteOpenHelper {

    private Context context;

    public MyDbHandler(@Nullable Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE "+Params.TABLE_NAME+"("+
                Params.KEY_ID+" INTEGER PRIMARY KEY,"+
                Params.KEY_NAME+" TEXT,"+
                Params.KEY_PHONE+" Text"+")";

        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Params.KEY_NAME,contact.getName());
        contentValues.put(Params.KEY_PHONE,contact.getPhoneNumber());

        long insert_resutl = db.insert(Params.TABLE_NAME,null,contentValues);
        Toast.makeText(context, "Successfully inserted : "+insert_resutl, Toast.LENGTH_SHORT).show();
        db.close();
    }

    public List<Contact> getAllContacts(){
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);
        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(cursor.getInt(0));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }

        return contactList;
    }

    public void deleteContact(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME,Params.KEY_NAME+"=?",new String[]{String.valueOf(name)});
        db.close();
    }
}
