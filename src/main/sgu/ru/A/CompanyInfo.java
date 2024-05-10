package src.main.sgu.ru.A;

public class CompanyInfo {
    public String ownerName;
    public String ownerSurname;
    public String ownerPatronymic;
    public String companyName;
    public Integer rating;

    public CompanyInfo(String ownerName, String ownerSurname, String ownerPatronymic, String companyName, Integer rating) {
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.ownerPatronymic = ownerPatronymic;
        this.companyName = companyName;
        this.rating = rating;
    }

    public String toString() {
        return this.ownerName + " " + this.ownerSurname + " " + this.ownerPatronymic + " " + this.companyName + " " + this.rating;
    }
}
