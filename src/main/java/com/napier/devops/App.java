package com.napier.devops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class App
{
    private Connection con;

    // Updated connect method
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/employees?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    // Disconnect method
    public void disconnect() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Disconnected from database");
            }
        } catch (SQLException e) {
            System.out.println("Error disconnecting: " + e.getMessage());
        }
    }

    // Main method updated to use command line args or default localhost
    public static void main(String[] args)
    {
        App app = new App();

        if(args.length < 2){
            // Default host: localhost:33060, delay 30000ms (30s)
            app.connect("localhost:33060", 30000);
        } else {
            // Use command line arguments: host and delay
            app.connect(args[0], Integer.parseInt(args[1]));
        }

        // Example usage
        Department dept = app.getDepartment("Development");  // Assuming getDepartment exists
        ArrayList<Employee> employees = app.getSalariesByDepartment(dept); // Assuming method exists

        // Print salary report
        app.printSalaries(employees);

        // Disconnect from database
        app.disconnect();
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

    // Dummy methods for compilation (replace with your actual implementations)
    public Department getDepartment(String name) {
        return new Department(); // Replace with real implementation
    }

    public ArrayList<Employee> getSalariesByDepartment(Department dept) {
        return new ArrayList<>(); // Replace with real implementation
    }
}
