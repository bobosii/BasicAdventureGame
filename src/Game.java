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
    }
}
