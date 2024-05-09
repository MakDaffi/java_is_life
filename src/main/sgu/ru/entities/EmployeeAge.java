package src.main.sgu.ru.entities;

public class EmployeeAge {
    public int id;
    public String employeeName;
    public int age;

    public EmployeeAge(int id, String employeeName, int age) {
        this.id = id;
        this.employeeName = employeeName;
        this.age = age;
    }

    public String toString() {
        return this.id + " " + this.employeeName + " " + this.age;
    }
}
