import java.util.Random;

public abstract class BattleLocation extends Location{
    private Monster monster;
    private String award;
    private int maxMonster;
    public BattleLocation(Player player, String name,Monster monster,String award,int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;

    }

    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterNumber();
        System.out.println("Şu anda buradasınız : " + this.getName());
        System.out.println("Dikkatli ol ! Burada " + monsterNumber + " Adet "+ this.getMonster().getName() + " yaşıyor !!");
        System.out.print("<S>avaş veya <K>aç : ");
        String selectBattleCase = input.nextLine();
        selectBattleCase = selectBattleCase.toUpperCase();
        if (selectBattleCase.equals("S") && combat(monsterNumber)){
                System.out.println(this.getName() + " tüm düşmanları yendiniz !");
                return true;
        }
        if (this.getPlayer().getHealth() <= 0){
            System.out.println("Öldünüz !");
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNumber){
        for (int i = 1; i <= monsterNumber; i++){
            this.getMonster().setHealth(this.getMonster().getOriginalHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0 ){
                int selectCombat = firstHit();
                if (selectCombat > 50){
                    System.out.println("Siz vurdunuz !");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0){
                        System.out.println();
                        System.out.println("Canavar size vurdu !");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0){
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                } else if (selectCombat < 50) {
                    System.out.println();
                    System.out.println("Canavar size vurdu !");
                    int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (monsterDamage < 0){
                        monsterDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                    afterHit();
                    if (this.getPlayer().getHealth() > 0){
                        System.out.println("Siz vurdunuz !");
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    }
                } else{
                    return false;
                }
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz !");
                System.out.println(this.getMonster().getAward() + " Para kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
                if (i == monsterNumber && this.getMonster().getName().equals("Zombi")){
                    this.getPlayer().getInventory().setFood(true);
                    System.out.println("Tebrikler yemek kazandınız !!");
                } else if (i == monsterNumber && this.getMonster().getName().equals("Vampir")) {
                    this.getPlayer().getInventory().setWater(true);
                    System.out.println("Tebrikler su kazandınız !!");
                } else if (i == monsterNumber && this.getMonster().getName().equals("Ayı")) {
                    this.getPlayer().getInventory().setWood(true);
                    System.out.println("Tebrikler odun kazandınız !!");
                } else if (i == monsterNumber && this.getMonster().getName().equals("Yılan")) {
                    snakeAward();
                }
            }
            playerStats();
        }
        return false;
    }
    public int firstHit(){
        Random r = new Random();
        return r.nextInt(100);
    }
    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + " Canavarının canı : " + this.getMonster().getHealth());
        System.out.println();
    }

    public void playerStats(){
        System.out.println("Oyuncu değerleri");
        System.out.println("-------------------");
        System.out.println("Sağlık : " + getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : " + getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + getPlayer().getMoney());
    }
    public void monsterStats(int i){
        System.out.println(i + "." +this.getMonster().getName() + " Değerleri :");
        System.out.println("-------------------");
        System.out.println("Sağlık : " + this.getMonster().getHealth());
        System.out.println("Hasar : " + this.getMonster().getDamage());
        System.out.println("Ödül : " + this.getMonster().getAward());
    }

    public int randomMonsterNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public void snakeAward(){
        Random r = new Random();
        int randomNumber = r.nextInt(100);
        if (randomNumber <= 15) {
            weaponRate();
        } else if (randomNumber <= 30) {
            armorRate();
        } else if (randomNumber <= 55) {
            moneyRate();
        } else {
            System.out.println("Hiç birşey kazanamadınız.");
        }
    };
    public void weaponRate(){
        Random r = new Random();
        int randomNumber = r.nextInt(100);
        if (randomNumber < 20){
            System.out.println("Tebrikler tüfek kazandınız");
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(3));
        } else if (randomNumber < 30) {
            System.out.println("Tebrikler kılıç kazandınız !!");
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(2));
        } else if (randomNumber > 50) {
            System.out.println("Tebrikler Tabanca kazandınız !!");
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(1));
        }
    }
    public void armorRate(){
        Random r = new Random();
        int randomNumber = r.nextInt(100);
        if (randomNumber <= 20){
            System.out.println("Tebrikler ağır zırh kazandınız");
            this.getPlayer().getInventory().setArmor(Armor.getArmorById(3));
        } else if (randomNumber <= 30) {
            System.out.println("Tebrikler orta zırh kazandınız !!");
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(2));
        } else if (randomNumber >= 50) {
            System.out.println("Tebrikler hafif zırh kazandınız !!");
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(1));
        }
    }
    public void moneyRate(){
        Random r = new Random();
        int randomNumber = r.nextInt(100);
        if (randomNumber < 20){
            System.out.println("Tebrikler 10 para kazandınız !!");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
        } else if (randomNumber < 30) {
            System.out.println("Tebrikler 5 para kazandınız !!");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
        } else if (randomNumber > 50) {
            System.out.println("Tebrikler 1 para kazandınız !!");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
        }
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
