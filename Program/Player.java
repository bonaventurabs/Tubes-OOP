  
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
    private boolean alreadyDraw = false;
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

    public void draw (){
        playerCardList.add(Deck.getTopCard());
        Deck.moveCardtoPlayer();

        if (discardable()){
            System.out.println("Kamu bisa langsung mengeluarkan kartu yang kamu ambil! Pilih 0 jika tidak ingin discard.");
            printDiscardable();
            Scanner scanDraw = new Scanner(System.in);
            System.out.println("Pilihan:");
            int pilihan = scanDraw.nextInt();
            if (pilihan!=0){
                discard(tmpCardList.get(pilihan-1));
            }
            //scanDraw.close();
        }
    }

    public void draw (int n){
        for (int i=0; i<n; i++){
            playerCardList.add(Deck.getTopCard());
            Deck.moveCardtoPlayer();
        }
    }

    public void drawFailHIJI(){
        System.out.println("Kamu gagal declare HIJI, draw kartu otomatis");
        draw(1);
    }

    public void drawWajib(){
        System.out.println("Kamu hanya bisa draw "+Deck.getPlusCounter()+" kartu");
        System.out.println("Draw otomatis.");
        draw(Deck.getPlusCounter());
        Deck.resetPlusCounter();
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
            Deck.setMultipleDiscard(1);

            // Discard
            discard(tmpCardList.get(pilihan-1));
            clearTmpCardList();

            // Cek bisa multiple discard
            while (multipleDiscardable(Deck.getDiscardPile())){
                System.out.println("Kamu bisa multiple discard, pilih 0 untuk tidak multiple discard.");
                printMultipleDiscardable(Deck.getDiscardPile());
                pilihan = scanDiscard.nextInt();
                if (pilihan==0) break;
                else {
                    discard(tmpCardList.get(pilihan-1));
                    Deck.setMultipleDiscard(Deck.getMultipleDiscard()+1);
                    clearTmpCardList();
                }
            }
            alreadyDraw = true;
            //scanDiscard.close();

        }
        else if (Deck.getDiscardPile() instanceof DrawTwoCard || Deck.getDiscardPile() instanceof DrawFourCard){
            drawWajib();
            alreadyDraw = true;
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

    private boolean multipleDiscardable(Card card){
        boolean retVal = false;

        for (Card myCard : playerCardList){
            if(((CardMethod)myCard).isEqual(card)){
                retVal = true;
                break;
            }
        }

        return retVal;
    }

    private void clearTmpCardList(){
        tmpCardList.clear();
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

    public void resetAlreadyDraw(){
        alreadyDraw = false;
    }
    public boolean getAlreadyDraw(){
        return alreadyDraw;
    }

}
