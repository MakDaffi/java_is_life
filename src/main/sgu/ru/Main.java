package main.sgu.ru;

public class Main {

    public void chooseMode() {
        System.out.println("Options:" +
                            "\n1. First task." +
                            "\n2. Second task." +
                            "\n3. Third task." +
                            "\n4. Exit.");
        System.out.print("Choose your option: ");
        String num = System.console().readLine();
        if (num.equals("1")) {
            A a = new A();
            a.main();
        }   
        else if (num.equals("2")) {
            B b = new B();
            b.main();
        }
        else if (num.equals("3")) {
            C c = new C();
            c.main();
        }
        else if (num.equals("4")) {
            System.out.println("\nStopping program...");
        }
        else {
            System.out.println("\nInvalid input!");
        } 
    }

    public static void main(String[] args) {
        Main a = new Main();
        a.chooseMode();
    }
}
