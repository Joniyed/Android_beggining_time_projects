package bd.edu.seu.mms.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import bd.edu.seu.mms.model_values.Value_DB;
import bd.edu.seu.mms.params.Params;

public class DbHelper extends SQLiteOpenHelper {

    Context context;

    public DbHelper(@Nullable Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
        this.context = context;
        Toast.makeText(context,"Db is created successfully",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE "+Params.TABLE_NAME+"("+
                Params.ID +" INTEGER PRIMARY KEY,"+
                Params.NAME+" TEXT,"+
                Params.PHONE_NUMBER + " TEXT"+ ")";
        sqLiteDatabase.execSQL(create);
        Toast.makeText(context, "Table successfully created..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addValue(Value_DB value_db){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Params.NAME,value_db.getName());
        contentValues.put(Params.PHONE_NUMBER,value_db.getPhone());

        sqLiteDatabase.insert(Params.TABLE_NAME,null,contentValues);
        Toast.makeText(context, "Value inserted successfully", Toast.LENGTH_SHORT).show();
    }

    public List<Value_DB> getValue(){
        List<Value_DB> getValues = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String select = "SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(select,null);

        if(cursor.moveToFirst()){
            do{
                Value_DB value_db = new Value_DB();
                value_db.setName(cursor.getString(1));
                value_db.setPhone(cursor.getString(2));
                getValues.add(value_db);
            }while (cursor.moveToNext());
        }

        return getValues;
    }
}
