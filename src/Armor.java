public class Armor {
    private int ID;
    private String name;
    private int price;
    private int block;

    public Armor(int ID, String name, int price, int block) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.block = block;
    }
    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1,"Hafif",15,1);
        armorList[1] = new Armor(2,"Orta",25,3);
        armorList[2] = new Armor(3,"Ağır",40,5);
        return armorList;
    }
    public static Armor getArmorById(int id){
        for (Armor a : Armor.armors()){
            if (a.getID() == id){
                return a;
            }
        }
        return null;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }
}
