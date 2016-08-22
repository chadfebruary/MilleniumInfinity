package com.milleniuminfinity.app.milleniuminfinity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Employee;
import com.milleniuminfinity.app.milleniuminfinity.repository.employee.EmployeeRepository;
import com.milleniuminfinity.app.milleniuminfinity.repository.employee.Impl.EmployeeRepositoryImpl;
import com.milleniuminfinity.app.milleniuminfinity.repository.tables.CreateDatabase;
import com.milleniuminfinity.app.milleniuminfinity.services.employee.Impl.EmployeeServiceImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ViewEmployee extends AppCompatActivity {

    EmployeeServiceImpl employeeService;
    ArrayAdapter adapter;
    ListView listView;
    String[] names;
    boolean isEmployeeBound = false;
    Set<Employee> employeeSet = new HashSet<>();
    List<Employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);

        //CreateDatabase createDatabase = new CreateDatabase(this.getApplicationContext());
        //createDatabase.createAllTables();

        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(this.getApplicationContext());

        employeeSet = new HashSet<>();
        try {
            employeeSet = employeeRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Iterator<Employee> employeeIterator = employeeSet.iterator();


        /*Intent intent = new Intent(this, EmployeeServiceImpl.class);

        CreateDatabase createDatabase = new CreateDatabase(this.getApplicationContext());
        try {
            createDatabase.createAllTables();
        } catch (Exception e) {
            e.printStackTrace();
        }

        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(this.getApplicationContext());
        employeeSet = new HashSet<>();

        try {
            employeeSet = employeeRepository.findAll("Manager");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Iterator<Employee> itEmployee = employeeSet.iterator();

        if(employeeSet.size() > 0)
        {
            names = new String[employeeSet.size()];

            int i = 0;

            while(itEmployee.hasNext())
            {
                names[i] = itEmployee.next().getName();
                i++;
            }

            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, names);

            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
        else
        {
            Toast.makeText(ViewEmployee.this, "No data", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void returnHome(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
