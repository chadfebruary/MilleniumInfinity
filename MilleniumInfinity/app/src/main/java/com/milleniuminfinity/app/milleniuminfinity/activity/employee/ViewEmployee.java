package com.milleniuminfinity.app.milleniuminfinity.activity.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.milleniuminfinity.app.milleniuminfinity.R;
import com.milleniuminfinity.app.milleniuminfinity.activity.MainActivity;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Employee;
import com.milleniuminfinity.app.milleniuminfinity.repository.employee.EmployeeRepository;
import com.milleniuminfinity.app.milleniuminfinity.repository.employee.Impl.EmployeeRepositoryImpl;
import com.milleniuminfinity.app.milleniuminfinity.repository.tables.CreateDatabase;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ViewEmployee extends AppCompatActivity {

    ArrayAdapter adapter;
    ListView listView;
    String[] names;
    Set<Employee> employeeSet = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);

        /*CreateDatabase createDatabase = new CreateDatabase(this.getApplicationContext());
        createDatabase.createAllTables();
*/
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(this.getApplicationContext());

        employeeSet = new HashSet<>();
        try
        {
            employeeSet = employeeRepository.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Iterator<Employee> employeeIterator = employeeSet.iterator();

        if(employeeSet.size()>0)
        {
            names = new String[employeeSet.size()];
            int i = 0;

            while(employeeIterator.hasNext())
            {
                names[i] = employeeIterator.next().getName();
                i++;
            }

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
            listView = (ListView)findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
        else
        {
            Toast.makeText(ViewEmployee.this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    public void returnHome(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
