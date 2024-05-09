package src.main.sgu.ru.entities;

public class EmployeeInfo {
    public int id;
    public String employeeName;
    public String departmentName;
    public String departmentLocation;

    public EmployeeInfo(int id, String employeeName, String departmentName, String departmentLocation) {
        this.id = id;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
        this.departmentLocation = departmentLocation;
    }

    public String toString() {
        return this.id + " " + this.employeeName + " " + this.departmentName + " " + this.departmentLocation;
    }
}
