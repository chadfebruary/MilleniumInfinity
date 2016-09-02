package com.milleniuminfinity.app.milleniuminfinity.activity.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.milleniuminfinity.app.milleniuminfinity.R;
import com.milleniuminfinity.app.milleniuminfinity.activity.MainActivity;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Employee;
import com.milleniuminfinity.app.milleniuminfinity.repository.employee.Impl.EmployeeRepositoryImpl;
import com.milleniuminfinity.app.milleniuminfinity.services.employee.Impl.EmployeeServiceImpl;

public class PreviewEmployee extends AppCompatActivity{

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

    public void addToDatabase(View v)
    {

        EmployeeServiceImpl employeeService = EmployeeServiceImpl.getInstance();
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(this.getApplicationContext());

            Employee employee = new Employee.Builder()
                    .name(name.getText().toString())
                    .surname(surname.getText().toString())
                    .dateOfBirth(dateOfBirth.getText().toString())
                    .role(role.getText().toString())
                    .build();

        //employeeService.addEmployee(getBaseContext(), employee);
        employeeRepository.save(employee);

        Intent intent = new Intent(this, EmployeeMenu.class);
        startActivity(intent);
    }

    public void returnHome(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
