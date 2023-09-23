
interface HavingSuperAbility {
    void applySuperAbility();
}
abstract class Hero implements HavingSuperAbility {
    private int health;
    private int damage;
    private String superAbility;

    public Hero(int health, int damage, String superAbility) {
        this.health = health;
        this.damage = damage;
        this.superAbility = superAbility;
    }

    @Override
    public void applySuperAbility() {
        System.out.println(superAbility);
    }
}
class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, "Magic применил суперспособность BAAANKAAAI");
    }
}
class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, "Medic применил суперспособность");
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    public void increaseExperience() {
        healPoints += healPoints * 0.10;
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Medic применил суперспособность MEGA ULTRA HEALTH");
    }
}
class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, "Warrior применил суперспособность CRITICAL DAMAGE");
    }
}

public class Main {
    public static void main(String[] args) {
        Hero[] heroes = {
                new Magic(100, 20),
                new Medic(80, 10, 50),
                new Warrior(150, 30)
        };
        for (Hero hero : heroes) {
            hero.applySuperAbility();
            if (hero instanceof Medic) {
                ((Medic) hero).increaseExperience();
                System.out.println("Опыт лечения увеличен до: " + ((Medic) hero).getHealPoints());
            }
        }
    }
}


