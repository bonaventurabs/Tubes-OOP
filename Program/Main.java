/**
 * Main/java
 * Driver Game HIJI
 */

import java.util.*;
//import kartu.*;

public class Main {
    public static void main(String[] args) {

        new Deck();

        // Pesan selamat datang
        System.out.println("Selamat datang di game HIJI");

        // Input ada berapa player
        System.out.println("Silakan input banyaknya pemain!");
        System.out.print("Banyak pemain: ");
        Scanner scanMain = new Scanner(System.in);
        int playerNum= scanMain.nextInt();
        System.out.println();

        // Kalo jumlah player ga 2-6
        while (playerNum<2||playerNum>6){
            System.out.println("Banyak pemain hanya bisa 2-6. Silakan ulangi input banyaknya pemain!");
            System.out.print("Banyak pemain: ");
            playerNum = scanMain.nextInt();
            System.out.println();
        }

        // Input nama-nama player
        System.out.println("Silakan input nama-nama pemain!");
        scanMain.nextLine();
        List<Player> playerList = new ArrayList<Player>();
        String name;
        for (int i=1; i<=playerNum; i++){
            System.out.print("Nama pemain "+i+": ");
            name = scanMain.nextLine();
            playerList.add(new Player(name));
        }
        

        // Start game
        Game game = new Game(playerList);
        game.startGame();

        // Looping game

        System.out.println();
        scanMain.nextLine();

        int pilihan;

        boolean noWinner = true, noAbort = true;
        while(noWinner&&noAbort){
            // Output pilihan menu
            pilihan = scanMain.nextInt();
            switch (pilihan){
                // Start game
                case 1:

                    break;
                // List cards
                case 2:
                    
                    break;
                // Discard
                case 3:
                
                    break;
                // Draw
                case 4:
                
                    break;
                // Declare HIJI
                case 5:
                
                    break;
                // List player
                case 6:
                
                    break;
                // View player in turn
                case 7:
                
                    break;
                // Help
                case 8:
                    System.out.println("Peraturan Permainan:");
                    System.out.println("");
                    break;
            }
        }

        scanMain.close();
    }
}
