package bd.edu.seu.dbdemo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import bd.edu.seu.dbdemo.model.Contact;
import bd.edu.seu.dbdemo.params.Params;

public class MyDbHandler extends SQLiteOpenHelper {
    Context context;
    public MyDbHandler(@Nullable Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE "+Params.TABLE_NAME+"("+
                Params.KEY_ID+" INTEGER PRIMARY KEY,"+
                Params.KEY_NAME+" TEXT,"+
                Params.KEY_PHONE+" TEXT)";
        Toast.makeText(context, "Successfully create Contact table", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addContact(Contact contact){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Params.KEY_NAME,contact.getName());
        contentValues.put(Params.KEY_PHONE,contact.getPhone_number());

        sqLiteDatabase.insert(Params.TABLE_NAME,null,contentValues);
        Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.close();
    }

    public List<Contact> getAllcontacts(){
        List<Contact> allcontacts = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String select = "SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(select,null);
        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(cursor.getInt(0));
                contact.setName(cursor.getString(1));
                contact.setPhone_number(cursor.getString(2));
                allcontacts.add(contact);
            }while (cursor.moveToNext());
        }
        return  allcontacts;
    }

    public int updateContac(String name,Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Params.KEY_NAME,contact.getName());
        contentValues.put(Params.KEY_PHONE,contact.getPhone_number());

        Toast.makeText(context, "Update SuccessFull",Toast.LENGTH_SHORT).show();

        return db.update(Params.TABLE_NAME,contentValues,Params.KEY_NAME+"=?",new String[]{name});
    }

    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME, Params.KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }

    public int totalContact(){
        int total=0;

        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM "+Params.TABLE_NAME;

        Cursor cursor = db.rawQuery(select,null);

        total = cursor.getCount();

        return total;
    }
}
