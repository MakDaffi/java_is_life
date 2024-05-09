package src.main.sgu.ru;

import java.sql.SQLException;
import java.util.ArrayList;

import src.main.sgu.ru.entities.DepartmentSalary;
import src.main.sgu.ru.entities.EmployeeAge;
import src.main.sgu.ru.entities.EmployeeInfo;

public class Main {
    public void main() throws SQLException, ClassNotFoundException {
        PostgresClient client = new PostgresClient("localhost", "5432", "task7", "postgres", "1234");
        System.out.println("Task1:");
        ArrayList<EmployeeAge> employeesAge = client.getEmployeesAge();
        for (EmployeeAge employeeAge: employeesAge) {
            System.out.println(employeeAge);
        }
        System.out.println("Task2:");
        ArrayList<DepartmentSalary> departmentsSalary = client.getAverageSalary();
        for (DepartmentSalary departmentSalary: departmentsSalary) {
            System.out.println(departmentSalary);
        }
        System.out.println("Task3:");
        ArrayList<EmployeeInfo> employeesInfo = client.getEmployeeInfo();
        for (EmployeeInfo employeeInfo: employeesInfo) {
            System.out.println(employeeInfo);
        }
    }
}
