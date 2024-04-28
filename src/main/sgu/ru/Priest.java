package src.main.sgu.ru;

class Priest extends BaseCharacter {

    public Priest(String name) {
        super(name, 50, 10, 15);
    }

    public void specialMove(Character enemyCharacter) {
        setHealth(getHealth() + 15);
    }
}
