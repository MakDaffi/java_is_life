package src.main.sgu.ru.entities;

public class DepartmentSalary {
    public int id;
    public String departmentName;
    public int averageSalary;

    public DepartmentSalary(int id, String departmentName, int averageSalary) {
        this.id = id;
        this.departmentName = departmentName;
        this.averageSalary = averageSalary;
    }

    public String toString() {
        return this.id + " " + " " + this.departmentName + " " + this.averageSalary;
    }
}
