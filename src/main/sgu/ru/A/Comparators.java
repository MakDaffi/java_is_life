package src.main.sgu.ru.A;

import java.util.Comparator;

class RatingComparator implements Comparator<CompanyInfo> {
    public int compare(CompanyInfo c1, CompanyInfo c2) {
        return c1.rating.compareTo(c2.rating);
    }
}

class SurnameComparator implements Comparator<CompanyInfo> {
    public int compare(CompanyInfo c1, CompanyInfo c2) {
        return c1.ownerSurname.compareTo(c2.ownerSurname);
    }
}

class NameComparator implements Comparator<CompanyInfo> {
    public int compare(CompanyInfo c1, CompanyInfo c2) {
        return c1.ownerName.compareTo(c2.ownerName);
    }
}

class PatronymicComparator implements Comparator<CompanyInfo> {
    public int compare(CompanyInfo c1, CompanyInfo c2) {
        return c1.ownerPatronymic.compareTo(c2.ownerPatronymic);
    }
}
