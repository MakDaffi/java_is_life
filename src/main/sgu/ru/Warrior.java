package src.main.sgu.ru;

import java.util.Random;

class Warrior extends BaseCharacter {

    public Warrior(String name) {
        super(name, 100, 10, 15);
    }

    @Override
    public void getDamage(int damage) {
        double damageAfterBlock = damage * 0.6;
        super.getDamage((int) damageAfterBlock);
    }

    @Override
    public void attack(Character enemyCharacter) {
        Random random = new Random();
        if (random.nextBoolean()) {
            int curDamage = random.nextInt(getMaxAttackPower() - getMinAttackPower()) + getMinAttackPower();
            enemyCharacter.getDamage(curDamage);
        }
    }

    @Override
    public void specialMove(Character enemyCharacter) {
        enemyCharacter.getDamage(20);
    }
}
