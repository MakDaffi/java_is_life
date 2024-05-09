package src.main.sgu.ru;

import java.util.Objects;
import java.util.Random;

interface Character {
    void getDamage(int damage);
    void attack(Character enemyCharacter);
    void specialMove(Character enemyCharacter);
    void autMove(Character enemyCharacter);
    
    boolean equals(Object object);
    int hashCode();
    int compareTo(Character character);
    String toString();
    Character shallowCopy();
    Character deepCopy();
}

class BaseCharacter implements Character {
    private String name;
    private int health;
    private int minAttackPower;
    private int maxAttackPower;

    public BaseCharacter(String name, int health, int minAttackPower, int maxAttackPower) {
        this.name = name;
        this.health = health;
        this.minAttackPower = minAttackPower;
        this.maxAttackPower = maxAttackPower;
    }
     
    public String getName() {
        return this.name;
    }

    public int getMinAttackPower() {
        return this.minAttackPower;
    }

    public int getMaxAttackPower() {
        return this.maxAttackPower;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int newHealth) {
        if (newHealth < this.health) {
            System.out.println(String.format("Персонаж %s получил %d единиц урона, текущее количество здоровья %d", this.getName(), this.health - newHealth, newHealth));
        } else {
            System.out.println(String.format("Персонаж %s восстановил %d единиц здоровья, текущее количество здоровья %d", this.getName(), newHealth - this.health, newHealth));
        }
        this.health = newHealth;
    }

    public void getDamage(int damage) {
        if (damage > getHealth()) {
            this.setHealth(0);
        } else {
            this.setHealth(getHealth() - damage);
        }
    }

    public void attack(Character enemyCharacter) {
        Random random = new Random();
        int curDamage = random.nextInt(this.maxAttackPower - this.minAttackPower) + this.minAttackPower;
        enemyCharacter.getDamage(curDamage);
    }

    public void specialMove(Character enemyCharacter) {
        System.out.println(toString() + " is trying to make powerful action, but unfortunately he can not do anything(");
    }

    public void autMove(Character enemyCharacter) {
        Random random = new Random();
            if (random.nextBoolean()) {
                this.attack(enemyCharacter);
            } else {
                this.specialMove(enemyCharacter);
            }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseCharacter that = (BaseCharacter) o;
        return Objects.equals(name, that.name) && 
            Objects.equals(minAttackPower, that.minAttackPower) &&
            Objects.equals(maxAttackPower, that.maxAttackPower);
    }

    public int hashCode() {
        return Objects.hash(toString());
    }


    public int compareTo(Character o) {
        return this.name.compareTo(o.toString());
    }

    public String toString() {
        return name + " : " + this.getClass().getSimpleName() + " : " + health + "HP";
    }

    public BaseCharacter shallowCopy() {
        try {
            return (BaseCharacter) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public BaseCharacter deepCopy() {
        return new BaseCharacter(this.name, this.health, this.minAttackPower, this.maxAttackPower);
    }
}