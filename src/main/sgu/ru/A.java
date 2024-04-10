package main.sgu.ru;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class A {
    final String dateTimePattern = "yyyy M d";
    
    public void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        LocalDate firstDate = LocalDate.parse(System.console().readLine("First date: "), formatter);
        LocalDate secondDate = LocalDate.parse(System.console().readLine("Second date: "), formatter);
        long diffDays = Duration.between(firstDate.atStartOfDay(), secondDate.atStartOfDay()).toDays();
        System.out.println(diffDays);
    }
}
