package com.milleniuminfinity.app.milleniuminfinity.repository.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.milleniuminfinity.app.milleniuminfinity.conf.databases.DBConstants;

import java.lang.Exception;
import java.lang.Override;

/**
 * Created by 208023429 on 5/13/2016.
 */
public class CreateDatabase extends SQLiteOpenHelper {


    private static CreateDatabase createDatabase;
    private Context context;
    private static SQLiteDatabase database;

    //Tables names
    public static final String TABLE_EMPLOYEE = "employee";
    public static final String TABLE_INTERNET = "internet";
    public static final String TABLE_SHOP = "shop";

    //Employee table columns
    public static final String COLUMN_EMPLOYEEID = "employeeID";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_DATEOFBIRTH = "dateOfBirth";
    public static final String COLUMN_ROLE = "role";

    //Employee table creation
    private static final String CREATE_TABLE_EMPLOYEE = " CREATE TABLE IF NOT EXISTS " +
            TABLE_EMPLOYEE + " (" +
            COLUMN_EMPLOYEEID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            //COLUMN_SHOPNUMBER + " INTEGER FOREIGN KEY REFERENCES shop(ShopNumber), " +
            COLUMN_NAME + " TEXT NOT NULL, " +
            COLUMN_SURNAME + " TEXT NOT NULL, " +
            COLUMN_DATEOFBIRTH + " TEXT NOT NULL, " +
            COLUMN_ROLE + " TEXT NOT NULL );";

    //Internet table columns
    public static final String COLUMN_IPADDRESS = "ipAddress";
    public static final String COLUMN_ISP = "isp";
    public static final String COLUMN_PLANNAME = "planName";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_DATAALLOWANCE = "dataAllowance";

    //Internet table creation
    private static final String CREATE_TABLE_INTERNET = " CREATE TABLE " +
            TABLE_INTERNET + " (" +
            COLUMN_IPADDRESS + "INTEGER PRIMARY KEY, " +
            //COLUMN_SHOPNUMBER + " INTEGER FOREIGN KEY REFERENCES shop(ShopNumber), " +
            COLUMN_ISP + "TEXT NOT NULL, " +
            COLUMN_PLANNAME + "TEXT NOT NULL, " +
            COLUMN_PRICE + "INTEGER NOT NULL, " +
            COLUMN_DATAALLOWANCE + "INTEGER NOT NULL );";

    //Shop table columns
    public static final String COLUMN_SHOPNUMBER = "shopNumber";
    public static final String COLUMN_SHOPNAME = "shopName";
    public static final String COLUMN_SHOPOWNER = "shopOwner";
    public static final String COLUMN_SHOPPHONENUMBER = "shopPhoneNumber";

    //Shop table creation
    /*private static final String CREATE_TABLE_SHOP = " CREATE TABLE " +
            TABLE_SHOP + " ( " +
            COLUMN_SHOPNUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_SHOPNAME + " TEXT NOT NULL, " +
            COLUMN_SHOPOWNER + " TEXT NOT NULL, " +
            COLUMN_SHOPNUMBER + " TEXT NOT NULL);";*/

    public CreateDatabase(Context context)
    {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
        database = super.getWritableDatabase();
        this.context = context;
    }

    public static CreateDatabase getInstance(Context context)
    {
        if(createDatabase == null)
        {
            createDatabase = new CreateDatabase(context);
        }

        return createDatabase;
    }

    private void openWritableConnection() throws Exception
    {
        database = super.getWritableDatabase();
    }

    private void openReadableConnection() throws Exception
    {
        database = super.getReadableDatabase();
    }

    public void createAllTables(){

        //database.execSQL(CREATE_TABLE_SHOP);
        database.execSQL(CREATE_TABLE_EMPLOYEE);
        database.execSQL(CREATE_TABLE_INTERNET);
    }

    public void dropAllTables() throws Exception {

        database.execSQL("DROP TABLE IF EXISTS " + TABLE_INTERNET);
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        //database.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOP);

        createDatabase = null;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        database = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void closeDatabaseConnection()
    {
        this.close();
    }
}
