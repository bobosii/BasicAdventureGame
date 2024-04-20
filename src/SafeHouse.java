public class SafeHouse extends Location {


    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz !");
        System.out.println("Canınız yenilendi !");
        return true;
    }

    public SafeHouse(Player player) {
        super(player, "Güvenli ev");
    }
}
