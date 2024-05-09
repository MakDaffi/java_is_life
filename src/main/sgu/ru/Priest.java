package src.main.sgu.ru;

class Priest extends BaseCharacter {

    public Priest(String name) {
        super(name, 50, 10, 15);
    }

    @Override
    public void specialMove(Character enemyCharacter) {
        this.setHealth(getHealth() + 15);
    }
}
