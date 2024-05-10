package src.main.sgu.ru.A;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public void main() {
        String file = System.console().readLine("Enter file name: ");
        ArrayList<CompanyInfo> companyInfoList = new ArrayList<CompanyInfo>();
        try
        {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try
                {
                    String[] processedLine = line.split(" ");
                    CompanyInfo companyInfo = new CompanyInfo(processedLine[0], processedLine[1], processedLine[2], processedLine[3], Integer.valueOf(processedLine[4]));
                    companyInfoList.add(companyInfo);
                }
                catch (java.lang.NullPointerException | IllegalArgumentException ex) {
                    System.out.println("Unable to process line " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex)  {
            System.out.println("File " + file + " not exist!");
        }
        System.out.println("Task1 :");
        Collections.sort(companyInfoList, new RatingComparator());
        Collections.reverse(companyInfoList);
        for (CompanyInfo companyInfo: companyInfoList) {
            System.out.println(companyInfo);
        }
        System.out.println("Task2 :");
        Collections.sort(companyInfoList, new SurnameComparator());
        for (CompanyInfo companyInfo: companyInfoList) {
            System.out.println(companyInfo);
        }
        System.out.println("Task3 :");
        Collections.sort(companyInfoList, new NameComparator());
        Collections.reverse(companyInfoList);
        for (CompanyInfo companyInfo: companyInfoList) {
            System.out.println(companyInfo);
        }
        System.out.println("Task4 :");
        Collections.sort(companyInfoList, new PatronymicComparator());
        for (CompanyInfo companyInfo: companyInfoList) {
            System.out.println(companyInfo);
        }
    }
}
