package src.main.sgu.ru;

public class Queries {
    public static final String GET_EMPLOYEES_AGE = "SELECT * FROM employeesAge WHERE age > 20;";

    public static final String GET_DEPARTMENT_SALARY = "SELECT id, departmentName, Avg(salary) as averageSalary FROM departmentSalary GROUP BY departmentName;";

    public static final String GET_EMPLOYEE_INFO = "SELECT * FROM employeeInfo;";
}
