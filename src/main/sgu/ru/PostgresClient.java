package src.main.sgu.ru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.main.sgu.ru.entities.DepartmentSalary;
import src.main.sgu.ru.entities.EmployeeAge;
import src.main.sgu.ru.entities.EmployeeInfo;

public class PostgresClient {
    private Connection connection;

    public PostgresClient(String host, String port, String databaseName, String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String connectionString = this.createConnectionString(host, port, databaseName);
        this.connection = DriverManager.getConnection(connectionString, username, password);
    }

    private String createConnectionString(String host, String port, String databaseName) {
        return "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;
    }

    private ResultSet executeQuery(String queries) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(queries);
        return resultSet;
    }

    public ArrayList<EmployeeAge> getEmployeesAge() throws SQLException{
        ResultSet resultSet = this.executeQuery(Queries.GET_EMPLOYEES_AGE);
        ArrayList<EmployeeAge> results = new ArrayList<EmployeeAge>();
        while (resultSet.next()) {
            EmployeeAge result = new EmployeeAge(resultSet.getInt("id"), resultSet.getString("employeeName"), resultSet.getInt("age"));
            results.add(result);
        }
        return results;
    }

    public ArrayList<DepartmentSalary> getAverageSalary() throws SQLException{
        ResultSet resultSet = this.executeQuery(Queries.GET_DEPARTMENT_SALARY);
        ArrayList<DepartmentSalary> results = new ArrayList<DepartmentSalary>();
        while (resultSet.next()) {
            DepartmentSalary result = new DepartmentSalary(resultSet.getInt("id"), resultSet.getString("departmentName"), resultSet.getInt("averageSalary"));
            results.add(result);
        }
        return results;
    }

    public ArrayList<EmployeeInfo> getEmployeeInfo() throws SQLException{
        ResultSet resultSet = this.executeQuery(Queries.GET_EMPLOYEE_INFO);
        ArrayList<EmployeeInfo> results = new ArrayList<EmployeeInfo>();
        while (resultSet.next()) {
            EmployeeInfo result = new EmployeeInfo(resultSet.getInt("id"), resultSet.getString("employeeName"), resultSet.getString("departmentName"), resultSet.getString("departmentLocation"));
            results.add(result);
        }
        return results;
    }

}
