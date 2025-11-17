package com.napier.devops;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    // --- Tests for printSalaries() ---

    @Test
    void printSalariesTestNull()
    {
        assertDoesNotThrow(() -> app.printSalaries(null));
    }

    @Test
    void printSalaries()
    {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee emp = new Employee();
        emp.emp_no = 1;
        emp.first_name = "Kevin";
        emp.last_name = "Chalmers";
        emp.title = "Engineer";
        emp.salary = 55000;
        employees.add(emp);

        assertDoesNotThrow(() -> app.printSalaries(employees));
    }

    // --- Tests for displayEmployee() ---

    @Test
    void displayEmployeeNull()
    {
        Employee emp = null;
        assertDoesNotThrow(() -> app.displayEmployee(emp));
    }

    @Test
    void displayEmployeeValid()
    {
        Employee emp = new Employee();
        emp.emp_no = 1;
        emp.first_name = "Kevin";
        emp.last_name = "Chalmers";
        emp.title = "Engineer";
        emp.salary = 55000;

        assertDoesNotThrow(() -> app.displayEmployee(emp));
    }

    @Test
    void displayEmployeePartial()
    {
        Employee emp = new Employee();
        emp.emp_no = 2;
        emp.first_name = "Anna";
        emp.last_name = null;  // missing last name
        emp.title = null;      // missing title
        emp.salary = 45000;

        assertDoesNotThrow(() -> app.displayEmployee(emp));
    }
}
