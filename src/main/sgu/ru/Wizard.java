package src.main.sgu.ru;

class Wizard extends BaseCharacter {

    public Wizard(String name) {
        super(name, 60, 5, 25);
    }

    @Override
    public void getDamage(int damage) {
        double damageAfterBlock = damage * 0.9;
        super.getDamage((int) damageAfterBlock);
    }
    
    @Override
    public void specialMove(Character enemyCharacter) {
        enemyCharacter.getDamage(30);
    }
}
