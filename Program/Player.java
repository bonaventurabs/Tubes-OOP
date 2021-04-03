  
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
    }
    public void discard(Card card) {

        boolean discardable = false;
        // cek apa ada kartu yg bisa didiscard
        for (Card myCard : playerCardList){
            if(((CardMethod)myCard).isLegalMove(Deck.getDiscardPile())) discardable = true;
        }
        // Ini print list yg bisa dikeluarin
        if (discardable){
            Deck.moveCardtoDeck(Deck.getDiscardPile());
            Deck.setDiscardPile(card);
            playerCardList.remove(card);
        }
        else {
            System.out.println("Tidak ada kartu yang bisa kamu discard, silahkan pilih draw");
            // abis draw bisa ngeluarin
        }
    }
    public void declareHIJI(){ // Masih ga tau bakal ngapain
        System.out.println("HIJI!"); 
    }
    public void cardList(){
        for (Card myCard : playerCardList){
            System.out.println(myCard.toString());
        }
    }
}
