package src.main.sgu.ru;

import java.util.Random;

public class Main {
    public void main(String[] args) {
        Warrior warrior = new Warrior("Иван");
        Priest priest = new Priest("Андрей");
        String winnerName = "";
        while (true) {
            Random random = new Random();
            if (random.nextBoolean()) {
                warrior.autMove(priest);
            } else {
                priest.autMove(warrior);
            }
            if (warrior.getHealth() == 0) {
                winnerName = priest.getName();
                break;
            } else if (priest.getHealth() == 0) {
                winnerName = warrior.getName();
                break;
            }
        }
        System.out.println(String.format("Победил %s!", winnerName));
    }
}
