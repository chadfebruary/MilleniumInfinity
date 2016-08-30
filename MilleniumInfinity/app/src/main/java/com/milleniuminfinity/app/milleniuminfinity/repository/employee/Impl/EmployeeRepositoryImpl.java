package com.milleniuminfinity.app.milleniuminfinity.repository.employee.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.milleniuminfinity.app.milleniuminfinity.conf.databases.DBConstants;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Cleaner;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Employee;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Manager;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.SalesRepresentative;
import com.milleniuminfinity.app.milleniuminfinity.repository.employee.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cfebruary on 2016/08/18.
 */
public class EmployeeRepositoryImpl extends SQLiteOpenHelper implements EmployeeRepository {

    public static final String TABLE_EMPLOYEE = "employee";
    private SQLiteDatabase database;

    public static final String COLUMN_EMPLOYEEID = "employeeid";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_DATEOFBIRTH = "dateofbirth";

    //Database table creation
    private static final String DATABASE_CREATE = " CREATE TABLE IF NOT EXISTS "
            + TABLE_EMPLOYEE + "("
            + COLUMN_EMPLOYEEID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT NOT NULL,"
            + COLUMN_SURNAME + " TEXT NOT NULL,"
            + COLUMN_DATEOFBIRTH + "TEXT NOT NULL);";

    public EmployeeRepositoryImpl(Context context)
    {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException
    {
        database = this.getWritableDatabase();
    }

    public void close()
    {
        this.close();
    }

    @Override
    public Employee findById(String employeeID, String role)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(
                TABLE_EMPLOYEE,
                new String[]{
                        COLUMN_EMPLOYEEID,
                        COLUMN_NAME,
                        COLUMN_SURNAME,
                        COLUMN_DATEOFBIRTH},
                COLUMN_EMPLOYEEID + " =? ",
                new String[]{String.valueOf(employeeID)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst())
        {
            if(role.equalsIgnoreCase("Manager")) {
                final Employee employee = new Manager.Builder()
                        .employeeID(cursor.getString(0))
                        .name(cursor.getString(1))
                        .surname(cursor.getString(2))
                        .dateOfBirth(cursor.getString(3))
                        .build();
                return employee;
            }
            else if(role.equalsIgnoreCase("Sales representative"))
            {
                final Employee employee = new SalesRepresentative.Builder()
                        .employeeID(cursor.getString(0))
                        .name(cursor.getString(1))
                        .surname(cursor.getString(2))
                        .dateOfBirth(cursor.getString(3))
                        .build();

                return employee;
            }
            else
            {
                final Employee employee = new Cleaner.Builder()
                        .employeeID(cursor.getString(0))
                        .name(cursor.getString(1))
                        .surname(cursor.getString(2))
                        .dateOfBirth(cursor.getString(3))
                        .build();

                return employee;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public Employee save(Employee employee)
    {
        open();
        ContentValues values = new ContentValues();

        values.put(COLUMN_EMPLOYEEID, employee.getEmployeeID());
        values.put(COLUMN_NAME, employee.getName());
        values.put(COLUMN_SURNAME, employee.getSurname());
        values.put(COLUMN_DATEOFBIRTH, employee.getDateOfBirth());

        Long employeeID = database.insertOrThrow(TABLE_EMPLOYEE, null, values);

        if(employee.getEmployeeRole().equalsIgnoreCase("Manager")) {
            final Employee insertedEntity = new Manager.Builder()
                    .copy((Manager)employee)
                    .employeeID(employeeID.toString())
                    .build();
            return insertedEntity;
        }
        else if(employee.getEmployeeRole().equalsIgnoreCase("Sales representative"))
        {
            final Employee insertedEntity = new SalesRepresentative.Builder()
                    .copy((SalesRepresentative)employee)
                    .employeeID(employeeID.toString())
                    .build();

            return insertedEntity;
        }
        else
        {
            final Employee insertedEntity = new Cleaner.Builder()
                    .copy((Cleaner)employee)
                    .employeeID(employeeID.toString())
                    .build();

            return insertedEntity;
        }
    }

    @Override
    public Employee update(Employee employee)
    {
        open();
        ContentValues values = new ContentValues();

        values.put(COLUMN_EMPLOYEEID, employee.getEmployeeID());
        values.put(COLUMN_NAME, employee.getName());
        values.put(COLUMN_SURNAME, employee.getSurname());
        values.put(COLUMN_DATEOFBIRTH, employee.getDateOfBirth());
        database.update(
                TABLE_EMPLOYEE,
                values,
                COLUMN_EMPLOYEEID + " =? ",
                new String[]{String.valueOf(employee.getEmployeeID())}
        );

        return employee;
    }

    @Override
    public Employee delete(Employee employee)
    {
        open();
        database.delete(
                TABLE_EMPLOYEE,
                COLUMN_EMPLOYEEID + " =? ",
                new String[]{String.valueOf(employee.getEmployeeID())}
        );

        return employee;
    }

    @Override
    public Set<Employee> findAll()
    {
        database = this.getReadableDatabase();
        String selectAll = " SELECT * FROM " + TABLE_EMPLOYEE;
        Set<Employee> employees = new HashSet<>();
        open();
        Cursor cursor = database.rawQuery(selectAll, null);

        if(cursor.moveToFirst())
        {
            do {

                final Employee employee;

                if(cursor.getString(4).equalsIgnoreCase("Manager")) {
                    employee = new Manager.Builder()
                            .employeeID(cursor.getString(0))
                            .name(cursor.getString(1))
                            .surname(cursor.getString(2))
                            .dateOfBirth(cursor.getString(3))
                            .build();
                }
                else if(cursor.getString(4).equalsIgnoreCase("Sales representative"))
                {
                    employee = new SalesRepresentative.Builder()
                            .employeeID(cursor.getString(0))
                            .name(cursor.getString(1))
                            .surname(cursor.getString(2))
                            .dateOfBirth(cursor.getString(3))
                            .build();
                }
                else
                {
                    employee = new Cleaner.Builder()
                            .employeeID(cursor.getString(0))
                            .name(cursor.getString(1))
                            .surname(cursor.getString(2))
                            .dateOfBirth(cursor.getString(3))
                            .build();
                }

                employees.add(employee);

            }while(cursor.moveToNext());
        }

        return employees;
    }

    @Override
    public int deleteAll()
    {
        open();
        int rowsDeleted = database.delete(TABLE_EMPLOYEE, null, null);
        //close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        onCreate(db);

    }
}