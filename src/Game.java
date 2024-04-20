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
            System.out.println("2- Mağaza --> Buradan istediğiniz eşyayı satın alabilirsiniz ! ");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if (!location.onLocation()){
                System.out.println("Game OVER !");
                break;
            }
        }
    }
}
