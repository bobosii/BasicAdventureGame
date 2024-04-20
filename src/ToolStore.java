public class ToolStore extends Location{
    @Override
    public boolean onLocation() {
        System.out.println("------- Mağazaya hoş geldiniz ! -------");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış yap");
            System.out.print("Seçiminiz : ");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3){
                System.out.println("Lütfen geçerli bir işlem seçiniz : ");
                selectCase = input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar bekleriz maceracı !");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }
    public void printWeapon(){
        System.out.println("----- Silahlar -----");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getID() + " - "+w.getName() + " < Para : " + w.getPrice() +", Hasar " +w.getDamage()+" >");
        }
        System.out.println("0 - Çıkış yap");

    }
    public void buyWeapon(){
        System.out.println("Bir silah seçiniz : ");
        int selectWeapon = input.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length){
            System.out.println("Lütfen geçerli bir işlem seçiniz : ");
            selectWeapon = input.nextInt();
        }
        if (selectWeapon != 0){
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeapon);
            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                }
                else {
                    // Satın alımın gerçekleştiği yer.
                    System.out.println(selectedWeapon.getName() + " Silahı envanterinize eklenmiştir.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }

    }
    public void printArmor(){
        System.out.println("----- Armorlar -----");
        for (Armor w : Armor.armors()){
            System.out.println(w.getID() + " - "+w.getName() + " < Para : " + w.getPrice() +", Zırh " +w.getBlock()+" >");
        }
        System.out.println("0 - Çıkış yap");
    }
    public void buyArmor(){
        System.out.print("Bir zırh seçiniz : ");
        int selectArmor = input.nextInt();
        while (selectArmor < 0 || selectArmor > Armor.armors().length){
            System.out.print("Lütfen geçerli bir işlem seçiniz : ");
            selectArmor = input.nextInt();
        }
        if (selectArmor != 0){
            Armor selectedArmor = Armor.getArmorById(selectArmor);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yetersiz bakiye !");
                }
                else {
                    System.out.println(selectedArmor.getName() + " Envanterinize eklenmiştir !");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    System.out.println("Önceki zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }

    }

}
