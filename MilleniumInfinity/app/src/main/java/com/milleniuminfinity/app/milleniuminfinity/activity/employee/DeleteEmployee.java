package com.milleniuminfinity.app.milleniuminfinity.activity.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.milleniuminfinity.app.milleniuminfinity.R;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Employee;
import com.milleniuminfinity.app.milleniuminfinity.repository.employee.Impl.EmployeeRepositoryImpl;

public class DeleteEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_employee);
    }

    public void deleteByID(View v)
    {
        String employeeID = ((EditText)findViewById(R.id.editText)).getText().toString();
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(this.getApplicationContext());
        Employee employee = new Employee.Builder()
                .employeeID(employeeID)
                .build();
        employeeRepository.delete(employee);
    }

    public void deleteAll(View v)
    {
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(this.getApplicationContext());
        int deleted = employeeRepository.deleteAll();

        if(deleted > 0)
        {
            Toast.makeText(DeleteEmployee.this, "Employees deleted successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(DeleteEmployee.this, "No employees to delete", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(this, EmployeeMenu.class);
        startActivity(intent);
    }
}
