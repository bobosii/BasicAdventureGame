public class ToolStore extends Location{
    @Override
    public boolean onLocation() {
        System.out.println("------- Mağazaya hoş geldiniz ! -------");
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
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Tekrar bekleriz maceracı !");
                return true;

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
        System.out.println("Bir silah seçiniz : ");
        int selectWeapon = input.nextInt();
        while (selectWeapon < 1 || selectWeapon > Weapon.weapons().length){
            System.out.println("Lütfen geçerli bir işlem seçiniz : ");
            selectWeapon = input.nextInt();
        }
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
    public void printArmor(){
        System.out.println("----- Zırhlar -----");
    }

}
