public class SafeHouse extends Location {


    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz !");
        System.out.println("Canınız yenilendi !");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        if (this.getPlayer().getInventory().isFood() && this.getPlayer().getInventory().isWater() && this.getPlayer().getInventory().isWood()){
            System.out.println("Tebrikler savaşçı oyunu başarıyla tamamladın..");
            System.out.println("Bir sonraki macerada görüşmek üzere <3 !");
            return false;
        } else{
            System.out.println("Bütün bölge eşyalarını tamamlayıp tekrar gel savaşçı !!");
            return true;
        }
    }

    public SafeHouse(Player player) {
        super(player, "Güvenli ev");
    }
}
