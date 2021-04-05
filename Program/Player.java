  
/**
 * Player.java
 * [Kelas Player] Masih banyak bingung 
 */

import java.util.*;
import kartu.*;

public class Player {
    private String nama;
    static int jumlahPlayer = 0;
    private List<Card> playerCardList = new ArrayList<Card>();
    private List<Card> tmpCardList = new ArrayList<Card>();
    private long startHIJI=-9999;

    public Player (String nama){
        this.nama = nama;   
        jumlahPlayer ++;

        playerCardList.add(Deck.getTopCard()); // kartu pertama
        Deck.moveCardtoPlayer();
        playerCardList.add(Deck.getTopCard()); // kartu kedua
        Deck.moveCardtoPlayer();
        playerCardList.add(Deck.getTopCard()); // kartu ketiga
        Deck.moveCardtoPlayer();
        playerCardList.add(Deck.getTopCard()); // kartu keempat
        Deck.moveCardtoPlayer();
        playerCardList.add(Deck.getTopCard()); // kartu kelima
        Deck.moveCardtoPlayer();
        playerCardList.add(Deck.getTopCard()); // kartu keenam
        Deck.moveCardtoPlayer();
        playerCardList.add(Deck.getTopCard()); // kartu ketujuh
        Deck.moveCardtoPlayer();

    }

    public void draw(int n){
        for (int i=0; i<n; i++){
            playerCardList.add(Deck.getTopCard());
            Deck.moveCardtoPlayer();
        }
    }

    public void discard(Card card){
        Deck.moveCardtoDeck(Deck.getDiscardPile());
        Deck.setDiscardPile(card);
        playerCardList.remove(card);
    }

    public void cardList(){
        int n = 1;
        for (Card myCard : playerCardList){
            System.out.println(n + ". "+((CardMethod)myCard).toString());
            n++;
        }
    }

    public boolean discardable(){
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

    public int printDiscardable(){
        int n = 1;
        for (Card myCard : playerCardList){
            if(((CardMethod)myCard).isLegalMove(Deck.getDiscardPile())){
                tmpCardList.add(myCard);
                System.out.println(n + ". "+((CardMethod)myCard).toString());
                n++;
            }
        }
        return n;
    }

    public boolean multipleDiscardable(Card card){
        boolean retVal = false;

        for (Card myCard : playerCardList){
            if(((CardMethod)myCard).isEqual(card)){
                retVal = true;
                break;
            }
        }

        return retVal;
    }

    public int printMultipleDiscardable(Card card){
        int n = 1;
        for (Card myCard : playerCardList){
            if(((CardMethod)myCard).isEqual(card)){
                tmpCardList.add(myCard);
                System.out.println(n + ". "+((CardMethod)myCard).toString());
                n++;
            }
        }
        return n;
    }

    public boolean haveDrawCard(){
        boolean retVal = false;
        for (Card myCard : playerCardList){
            if(myCard instanceof DrawFourCard || myCard instanceof DrawTwoCard){
                retVal = true;
                break;
            }
        }
        return retVal;
    }

    public void clearTmpCardList(){
        tmpCardList.clear();
    }
    public Card getTmpCardList(int n){
        return tmpCardList.get(n);
    }

    public boolean declareHIJI(){ 
        return (getNumOfCard()==1 && System.currentTimeMillis()-startHIJI<=3000);
    }

    public String getNama(){
        return nama;
    }

    public int getNumOfCard(){
        return playerCardList.size();
    }

}
