package com.milleniuminfinity.app.milleniuminfinity.activity.employee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.milleniuminfinity.app.milleniuminfinity.R;
import com.milleniuminfinity.app.milleniuminfinity.activity.MainActivity;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Cleaner;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Employee;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Manager;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.SalesRepresentative;
import com.milleniuminfinity.app.milleniuminfinity.repository.tables.CreateDatabase;
import com.milleniuminfinity.app.milleniuminfinity.services.employee.Impl.EmployeeServiceImpl;

public class PreviewEmployee extends AppCompatActivity {

    Employee employee;
    TextView name, surname, dateOfBirth, role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_employee);

        Bundle extras = getIntent().getExtras();
        employee = (Employee)extras.getSerializable("EMPLOYEE");

        name = ((TextView)findViewById(R.id.textView1));
        name.setText(employee.getName());

        surname = ((TextView)findViewById(R.id.textView2));
        surname.setText(employee.getSurname());

        dateOfBirth = ((TextView)findViewById(R.id.textView3));
        dateOfBirth.setText(employee.getDateOfBirth());

        role = ((TextView)findViewById(R.id.textView4));
        role.setText(employee.getEmployeeRole());
    }

    public void addToDatabase(View v) throws Exception
    {
        CreateDatabase createDatabase = CreateDatabase.getInstance(this.getApplicationContext());
        createDatabase.createAllTables();

        EmployeeServiceImpl employeeService = EmployeeServiceImpl.getInstance();

        if(role.equals("Manager")) {
            Employee employee = new Manager.Builder()
                    .name(name.getText().toString())
                    .surname(surname.getText().toString())
                    .dateOfBirth(dateOfBirth.getText().toString())
                    .role(role.getText().toString())
                    .build();
        }
        else if(role.equals("Sales representative")){
            Employee employee = new SalesRepresentative.Builder()
                    .name(name.getText().toString())
                    .surname(surname.getText().toString())
                    .dateOfBirth(dateOfBirth.getText().toString())
                    .role(role.getText().toString())
                    .build();
        }
        else
        {
            Employee employee = new Cleaner.Builder()
                    .name(name.getText().toString())
                    .surname(surname.getText().toString())
                    .dateOfBirth(dateOfBirth.getText().toString())
                    .role(role.getText().toString())
                    .build();
        }
        employeeService.addEmployee(this.getApplication(), employee);

        Intent intent = new Intent(this, EmployeeMenu.class);
        startActivity(intent);
    }

    public void returnHome(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
