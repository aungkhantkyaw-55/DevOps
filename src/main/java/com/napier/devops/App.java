package com.napier.devops;

import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        App app = new App();

        // Example calls
        app.printSalaries(null);

        Employee emp = new Employee();
        emp.emp_no = 1;
        emp.first_name = "Kevin";
        emp.last_name = "Chalmers";
        emp.title = "Engineer";
        emp.salary = 55000;

        app.displayEmployee(emp);
    }

    // Print multiple employees
    public void printSalaries(ArrayList<Employee> employees)
    {
        if (employees == null)
        {
            System.out.println("No employees");
            return;
        }

        System.out.println(String.format("%-10s %-15s %-20s %-20s %-8s",
                "Emp No", "First Name", "Last Name", "Title", "Salary"));

        for (Employee emp : employees) {
            String emp_string = String.format("%-10s %-15s %-20s %-20s %-8s",
                    emp.emp_no,
                    emp.first_name != null ? emp.first_name : "",
                    emp.last_name != null ? emp.last_name : "",
                    emp.title != null ? emp.title : "",
                    emp.salary);
            System.out.println(emp_string);
        }
    }

    // Print a single employee
    public void displayEmployee(Employee emp)
    {
        if (emp == null)
        {
            System.out.println("No employee data");
            return;
        }

        System.out.println(String.format("%-10s %-15s %-20s %-20s %-8s",
                "Emp No", "First Name", "Last Name", "Title", "Salary"));

        System.out.println(String.format("%-10s %-15s %-20s %-20s %-8s",
                emp.emp_no,
                emp.first_name != null ? emp.first_name : "",
                emp.last_name != null ? emp.last_name : "",
                emp.title != null ? emp.title : "",
                emp.salary));
    }
}
