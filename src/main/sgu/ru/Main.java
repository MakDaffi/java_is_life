package main.sgu.ru;

import java.util.Scanner;

public class Main {

    public void chooseMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options:" +
                            "\n1. First task." +
                            "\n2. Second task." +
                            "\n3. Third task." +
                            "\n4. Exit.");
        System.out.print("Choose your option: ");
        String bl = scanner.next();
        scanner.nextLine();
        if (bl.equals("1")) {
            A a = new A();
            a.main();
        }   
        else if (bl.equals("2")) {
            B b = new B();
            b.main();
        }
        else if (bl.equals("3")) {
            C c = new C();
            c.main();
        }
        else if (bl.equals("4")) {
            System.out.println("\nStopping program...");
        }
        else {
            System.out.println("\nInvalid input!");
        }
        scanner.close();
    
    }

    public static void main(String[] args) {
        Main a = new Main();
        a.chooseMode();
    }
}
