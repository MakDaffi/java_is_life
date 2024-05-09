package src.main.sgu.ru;

class Thief extends BaseCharacter {

    public Thief(String name) {
        super(name, 40, 20, 25);
    }

    public void specialMove(Character enemyCharacter) {
        this.setHealth(getHealth() + 8);
        enemyCharacter.getDamage(8);
    }
}
