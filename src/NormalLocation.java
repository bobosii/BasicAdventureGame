public class NormalLocation extends Location{
    @Override
    public boolean onLocation() {
        return true;
    }

    public NormalLocation(Player player, String name) {
        super(player, name);
    }
}
