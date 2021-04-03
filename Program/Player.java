  
/**
 * Player.java
 * [Kelas Player] Masih banyak bingung 
 */

import java.util.*;
import kartu.*;

public class Player {
    public String nama;
    static int jumlahPlayer = 0;
    private List<Card> playerCardList = new ArrayList<Card>();
    private List<Card> tmpCardList = new ArrayList<Card>();

    public Player (String nama){
        this.nama = nama;   
        jumlahPlayer ++;

        playerCardList.add(Deck.getTopCard()); // kartu pertama
        playerCardList.add(Deck.getTopCard()); // kartu kedua
        playerCardList.add(Deck.getTopCard()); // kartu ketiha
        playerCardList.add(Deck.getTopCard()); // kartu keempat
        playerCardList.add(Deck.getTopCard()); // kartu kelima
        playerCardList.add(Deck.getTopCard()); // kartu keenam
        playerCardList.add(Deck.getTopCard()); // kartu ketujuh

    }

    public void draw (){
        playerCardList.add(Deck.getTopCard());
        Deck.moveCardtoPlayer();

        if (discardable()){
            Scanner scanDraw = new Scanner(System.in);
            int pilihan = scanDraw.nextInt();
            System.out.println("Kamu bisa langsung mengeluarkan kartu yang kamu ambil! Pilih 0 jika tidak ingin discard.");
            printDiscardable();
            if (pilihan!=0){
                discard(tmpCardList.get(pilihan-1));
            }
            scanDraw.close();
        }
    }

    public void draw (int n){
        for (int i=0; i<n; i++){
            playerCardList.add(Deck.getTopCard());
            Deck.moveCardtoPlayer();
        }
    }

    private void discard(Card card){
        Deck.moveCardtoDeck(Deck.getDiscardPile());
        Deck.setDiscardPile(card);
        playerCardList.remove(card);
    }

    public void discardCMD() {

        if (discardable()){

            // Print + minta pilihan discard
            System.out.println("List Kartu yang bisa didiscard:");
            printDiscardable();
            Scanner scanDiscard = new Scanner(System.in);
            int pilihan = scanDiscard.nextInt();

            // Discard
            discard(tmpCardList.get(pilihan-1));
            clearTmpCardList();

            // Cek bisa multiple discard
            while (discardable()){
                System.out.println("Kamu bisa multiple discard, pilih 0 untuk tidak multiple discard.");
                printMultipleDiscardable(Deck.getDiscardPile());
                pilihan = scanDiscard.nextInt();
                if (pilihan==0) break;
                else {
                    discard(tmpCardList.get(pilihan-1));
                    clearTmpCardList();
                }
            }

            scanDiscard.close();

        }
        else {
            System.out.println("Tidak ada kartu yang bisa kamu discard, silahkan pilih draw");
            // abis draw bisa ngeluarin
        }
    }

    public void cardList(){
        int n = 1;
        for (Card myCard : playerCardList){
            System.out.println(n + ". "+((CardMethod)myCard).toString());
            n++;
        }
    }

    private boolean discardable(){
        boolean retVal = false;
        // cek apa ada kartu yg bisa didiscard
        for (Card myCard : playerCardList){
            if(((CardMethod)myCard).isLegalMove(Deck.getDiscardPile())){
                retVal = true;
                break;
            }
        }
        return retVal;
    }

    private void printDiscardable(){
        int n = 1;
        for (Card myCard : playerCardList){
            if(((CardMethod)myCard).isLegalMove(Deck.getDiscardPile())){
                tmpCardList.add(myCard);
                System.out.println(n + ". "+((CardMethod)myCard).toString());
                n++;
            }
        }
    }

    private void printMultipleDiscardable(Card card){
        int n = 1;
        for (Card myCard : playerCardList){
            if(((CardMethod)myCard).isEqual(card)){
                tmpCardList.add(myCard);
                System.out.println(n + ". "+((CardMethod)myCard).toString());
                n++;
            }
        }
    }

    private void clearTmpCardList(){
        tmpCardList.clear();
    }

    public void declareHIJI(){ // Masih ga tau bakal ngapain
        System.out.println("HIJI!"); 
    }

}
