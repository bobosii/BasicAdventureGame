import java.util.Scanner;
public class Game {

    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Değerli " + player.getPlayerName() + " başlayacağın uzun yolculukta başarılar dileriz...");
        System.out.println("Lütfen bir karakter seçin : ");
        player.selectChar();
        Location location = null;
        while(true){
            player.printInfo();
            System.out.println("--------- Bölgeler ---------\n\n");
            System.out.println("1- Güvenli ev --> Burası sizin için güvenli bir ev burada düşman yok !");
            System.out.println("2- Eşya dükkanı --> Buradan istediğiniz eşyayı satın alabilirsiniz ! ");
            System.out.println("3- Mağara --> <Ödül : Yemek>  Dikkatli ol karşına zombiler çıkabilir ! !");
            System.out.println("4- Orman --> <Ödül : Odun>  Dikkatli ol karşına vampirler çıkabilir !");
            System.out.println("5- Nehir --> <Ödül : Su>  Dikkatli ol karşına ayılar çıkabilir !");
            System.out.println("0 - Oyunu sonlandır");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge seçiniz !");
            }
            if (location == null){
                System.out.println("Oyun bitti görüşmek üzere !");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game OVER !");
                break;
            }
        }
    }
}
