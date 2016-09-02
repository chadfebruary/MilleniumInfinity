package com.milleniuminfinity.app.milleniuminfinity.activity.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.milleniuminfinity.app.milleniuminfinity.R;
import com.milleniuminfinity.app.milleniuminfinity.activity.MainActivity;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Employee;

public class AddEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
    }

    public void returnHome(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void previewEmployee(View v)
    {
        Intent intent = new Intent(this, PreviewEmployee.class);

        String name = ((EditText)findViewById(R.id.editText1)).getText().toString();
        String surname = ((EditText)findViewById(R.id.editText2)).getText().toString();
        String dateOfBirth = ((EditText)findViewById(R.id.editText3)).getText().toString();
        String role = ((EditText)findViewById(R.id.editText4)).getText().toString();

        Employee employee = new Employee.Builder()
                .name(name)
                .surname(surname)
                .dateOfBirth(dateOfBirth)
                .role(role)
                .build();

        intent.putExtra("EMPLOYEE", employee);

        startActivity(intent);
    }
}
