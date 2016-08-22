package com.milleniuminfinity.app.milleniuminfinity.factories.employee;


import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Cleaner;
import com.milleniuminfinity.app.milleniuminfinity.domain.employee.Employee;

import java.io.Serializable;

/**
 * Created by 208023429 on 5/13/2016.
 */
public class CleanerFactory implements Serializable {

    public static Employee getCleaner(String employeeID, String type, String name, String surname, String dateOfBirth) {
        Employee cleaner = new Cleaner.Builder()
                .name(name)
                .surname(surname)
                .dateOfBirth(dateOfBirth)
                .employeeID(employeeID)
                .build();

        return cleaner;
    }
}
