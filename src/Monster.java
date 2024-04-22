import java.util.Random;

public class Monster {
    private int ID;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int originalHealth;


    public Monster(int ID,String name ,int damage, int health, int award) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.award = award;
        this.originalHealth = health;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        if (health < 0){
            health = 0;
        }
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public int randomSnakeDamage(){
        Random r = new Random();
        return r.nextInt(3) + 3;
    }
}
