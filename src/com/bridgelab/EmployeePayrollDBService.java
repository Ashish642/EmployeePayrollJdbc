package com.bridgelab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {
    /* To read employee payroll from database using JDBC */
    public List<EmployeePayrollData> readData() {
        String sql = "SELECT * FROM employee_payroll";
        List<EmployeePayrollDB> employeePayrollDBList = new ArrayList<>();
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDoublre("salary");
                LocalDate startDate = resultSet.get("start_date").toLocalDate();
                employeePayRollList.add(new EmployeePayrollData(id , name, salary,startDate));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollDBList;
    }
    /* Creating connection with the database */
    private Connection getConnection() throws  SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?usesSSL=false";
        String userName = "root";
        String password = "Pappu@3302";
        Connection connection;
        System.out.println("Connection to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL,userName,password);
        System.out.println("Connetion is successful!!!!" + connection);
        return connection;
    }
}
