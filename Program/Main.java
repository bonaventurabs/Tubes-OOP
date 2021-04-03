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

        // Looping game

        System.out.println();
        scanMain.nextLine();

        int pilihan=0;

        // Start game
        while (pilihan!=1){
            // Output pilihan menu

            System.out.println("Pilihan menu:");
            System.out.println("1. Start game");
            System.out.println("2. List card");
            System.out.println("3. Discard");
            System.out.println("4. Draw");
            System.out.println("5. Declare HIJI");
            System.out.println("6. List Player");
            System.out.println("7. View Player in Turn");
            System.out.println("8. Help");

            pilihan = scanMain.nextInt();
            if (pilihan!=1){
                System.out.println("Kamu belum start game");
            }
        }

        System.out.println("Game HIJI dimulai!");
        Game game = new Game(playerList);
        game.startGame();


        boolean noWinner = true, noAbort = true;
        while(noWinner&&noAbort){
            // Output pilihan menu

            System.out.println("Pilihan menu:");
            System.out.println("1. List card");
            System.out.println("2. Discard");
            System.out.println("3. Draw");
            System.out.println("4. Declare HIJI");
            System.out.println("5. List Player");
            System.out.println("6. View Player in Turn");
            System.out.println("7. Help");

            pilihan = scanMain.nextInt();
            switch (pilihan){
                // List cards
                case 1:
                    game.getPlayerInTurn().cardList();
                    break;
                // Discard
                case 2:
                    game.getPlayerInTurn().discardCMD();
                    break;
                // Draw
                case 3:
                    game.getPlayerInTurn().draw();
                    break;
                // Declare HIJI
                case 4:
                    game.getPlayerInTurn().declareHIJI();
                    break;
                // List player
                case 5:

                    for (int i=1; i<=playerNum; i++){

                    }

                    break;
                // View player in turn
                case 6:
                
                    break;
                // Help
                case 7:
                    System.out.println("Peraturan Permainan:");
                    System.out.println("1) HIJI dimainkan oleh 2-6 pemain.");
                    System.out.println("2) Di awal permainan, semua pemain akan mendapatkan 7 buah kartu, dan satu kartu angka dipilih secara acak untuk dijadikan kartu awal.");
                    System.out.println("3) Pemain yang akan memulai giliran pertama akan diacak.");
                    System.out.println("4) Aturan permainan adalah sebagai berikut.");
                    System.out.println("a) Pada setiap giliran, pemain boleh mengeluarkan satu atau lebih kartu yang dapat dimainkan pada giliran tersebut. Ketentuan kartu apa saja yang boleh dikeluarkan ada pada tabel Jenis Kartu.");
                    System.out.println("b) Apabila pemain tidak mengeluarkan kartu, pemain wajib mengambil satu kartu dari deck.");
                    System.out.println("c) Apabila kartu yang baru diambil tersebut bisa dikeluarkan, pemain boleh mengeluarkan kartu tersebut (tidak wajib).");
                    System.out.println("d) Apabila kartu tersebut tidak dapat dimainkan, maka giliran diselesaikan tanpa mengeluarkan kartu.");
                    System.out.println("5) Beberapa jenis kartu memiliki power tertentu yang dapat memengaruhi jalannya permainan.");
                    System.out.println("a) Reverse Card:");
                    System.out.println("b) Skip Card: ");
                    System.out.println("c) Draw Two Card: ");
                    System.out.println("d) Draw Four Card: ");
                    System.out.println("6) Apabila pemain memiliki sisa satu kartu, maka pemain harus melakukan “Declare HIJI” dalam waktu 3 detik. Apabila tidak, pemain wajib mengambil dua kartu dari deck.");
                    System.out.println("7) Pemain dinyatakan menang apabila kartu yang dipegangnya sudah habis, dan permainan selesai.");
                    break;
            }
        }

        scanMain.close();
    }
}
