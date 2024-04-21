public class Monster {
    private int ID;
    private String name;
    private int damage;
    private int health;


    public Monster(int ID,String name ,int damage, int health) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.health = health;
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
}
