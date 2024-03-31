import java.util.Scanner;
public class Player {
    private int damage;
    private int health;
    private int money;
    private String playerName;
    private String charName;
    private Scanner input = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
    }
    public void selectChar(){
        GameCharacter[] CharList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("Karakterler");
        System.out.println("------------------------------------------------------");

        for (GameCharacter gameCharacter: CharList){
            System.out.println("ID: " +gameCharacter.getId()+ "\tKarakter: "+ gameCharacter.getName() +
                    "\t Hasar: "+gameCharacter.getDamage() +
                    "\t Sağlık: "+gameCharacter.getHealth() +
                    "\t Para: " + gameCharacter.getMoney());
        }
        System.out.println("------------------------------------------------------");
        System.out.print("Karakter seçiniz : ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Lütfen geçerli bir karakter seçiniz.");
        }
        System.out.println("Karakteriniz : " + this.getCharName() + " Hasarınız : " +
                this.getDamage() + " Sağlık değeriniz : " + this.getHealth() +
                " Paranız : " + this.getMoney());
    }
    public void initPlayer(GameCharacter gameCharacter){
        this.setCharName(gameCharacter.getName());
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}
