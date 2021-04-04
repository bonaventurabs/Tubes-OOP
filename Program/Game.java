/**
 * Game.java
 * [Class Game]
 */

import java.util.*;
import kartu.*;

public class Game {

    private final List<Player> playerList;
    private int playerTurnIdx;
    private boolean reversed;
    private boolean harusDeclareHIJI = false;

    /**
     * Constructor Game
     */
    public Game (List<Player> playerList){
        this.playerList = playerList;
    }


    /**
     * Method ngacak turn awal
     */
    public void randomTurn(){
        Collections.shuffle(playerList);
    }

    /**
     * Method turn pertama / start game
     */
    public void startGame(){
        randomTurn();
        playerTurnIdx = 0;
        reversed = false;
    }


    /**
     * Method playerDraw
     */
    public void playerDraw(){
        System.out.println("Kartu di discard pile: "+Deck.getDiscardPile().toString());
        if (Deck.getDiscardPile() instanceof DrawTwoCard || Deck.getDiscardPile() instanceof DrawFourCard){
            getPlayerInTurn().drawWajib();
        }
        else {
            getPlayerInTurn().draw();
            nextTurn();
            System.out.println("Giliran kamu selesai, giliran selanjutnya: "+getPlayerInTurn().getNama());
        }
    }

    /**
     * Method playerDiscard
     */
    public void playerDiscard(){
        //System.out.println("Kartu di discard pile: "+Deck.getDiscardPile().toString());
        getPlayerInTurn().discardCMD();
        if (Deck.getDiscardPile() instanceof Wildcard){
            System.out.println("Kamu mengeluarkan wildcard, pilihan warna:");
            System.out.println("1. Merah");
            System.out.println("2. Kuning");
            System.out.println("3. Hijau");
            System.out.println("4. Biru");
            Scanner scanWild = new Scanner(System.in);
            int n = scanWild.nextInt();
            while (n<1||n>4){
                System.out.println("Pilihan salah, pilihan warna:");
                System.out.println("1. Merah");
                System.out.println("2. Kuning");
                System.out.println("3. Hijau");
                System.out.println("4. Biru");
                n = scanWild.nextInt();
            }
            switch (n){
                case 1:
                    ((Wildcard)(Deck.getDiscardPile())).setNextWarna(CardColor.MERAH);
                    break;
                case 2:
                    ((Wildcard)(Deck.getDiscardPile())).setNextWarna(CardColor.KUNING);
                    break;
                case 3:
                    ((Wildcard)(Deck.getDiscardPile())).setNextWarna(CardColor.HIJAU);
                    break;
                case 4:
                    ((Wildcard)(Deck.getDiscardPile())).setNextWarna(CardColor.BIRU);
                    break;
            }
            //scanWild.close();
        }
        else if (Deck.getDiscardPile() instanceof DrawFourCard){
            System.out.println("Kamu mengeluarkan DrawFour, pilihan warna:");
            System.out.println("1. Merah");
            System.out.println("2. Kuning");
            System.out.println("3. Hijau");
            System.out.println("4. Biru");
            Scanner scanWild = new Scanner(System.in);
            int n = scanWild.nextInt();
            while (n<1||n>4){
                System.out.println("Pilihan salah, pilihan warna:");
                System.out.println("1. Merah");
                System.out.println("2. Kuning");
                System.out.println("3. Hijau");
                System.out.println("4. Biru");
                n = scanWild.nextInt();
            }
            switch (n){
                case 1:
                    ((DrawFourCard)(Deck.getDiscardPile())).setNextWarna(CardColor.MERAH);
                    break;
                case 2:
                    ((DrawFourCard)(Deck.getDiscardPile())).setNextWarna(CardColor.KUNING);
                    break;
                case 3:
                    ((DrawFourCard)(Deck.getDiscardPile())).setNextWarna(CardColor.HIJAU);
                    break;
                case 4:
                    ((DrawFourCard)(Deck.getDiscardPile())).setNextWarna(CardColor.BIRU);
                    break;
            }
            //scanWild.close();
        }
        if (getPlayerInTurn().getAlreadyDraw()){
            if (getPlayerInTurn().getNumOfCard()==1){
                declareHIJICommand();
            }
            else {
                nextTurn();
                System.out.println("Giliran kamu selesai, giliran selanjutnya: "+getPlayerInTurn().getNama());
                getPlayerInTurn().resetAlreadyDraw();
            }
        }
    }

    public void declareHIJICommand(){
        harusDeclareHIJI = true;
    }
    
    public boolean getHarusDeclareHIJI(){
        return harusDeclareHIJI;
    }

    public void udahDeclareHIJI(){
        harusDeclareHIJI = false;
    }

    /**
     * Method turn selanjutnya
     */
    public void nextTurn() {

        // Cek kartu di discard Pile
        if (Deck.getDiscardPile() instanceof NumberCard){
            nextIdxNumberCard(1);
        }
        else if (Deck.getDiscardPile() instanceof SkipCard){
            nextIdxNumberCard(Deck.getMultipleDiscard()+1);
        }
        else if (Deck.getDiscardPile() instanceof ReverseCard){
            reverseIdx(Deck.getMultipleDiscard());
            nextIdxNumberCard(1);
        }
        else if (Deck.getDiscardPile() instanceof DrawTwoCard){
            Deck.addPlusCounter(2);
            nextIdxNumberCard(1);
        }
        else if (Deck.getDiscardPile() instanceof DrawFourCard){
            Deck.addPlusCounter(4);
            nextIdxNumberCard(1);
            //getPlayerInTurn().draw(Deck.getPlusCounter());
            //Deck.resetPlusCounter();
            //nextIdxNumberCard(1);
        }
        else if (Deck.getDiscardPile() instanceof Wildcard){
            nextIdxNumberCard(1);
        }
        
    }

    private void nextIdxNumberCard(int n){
        for (int i=0; i<n; i++){
            if (reversed) {
                if (playerTurnIdx == 0) {
                    playerTurnIdx = playerList.size() - 1;
                } else {
                    playerTurnIdx -= 1;
                }
            }
            else {
                if (playerTurnIdx == playerList.size() - 1) {
                    playerTurnIdx = 0;
                } else {
                    playerTurnIdx++;
                }
            }
        }
    }
    
    private void reverseIdx(int n){
        for (int i=0; i<n; i++){
            if (reversed) reversed = false;
            else reversed = true;
        }
    }

    public Player getPlayerInTurn(){
        return playerList.get(playerTurnIdx);    
    }

    public void printPlayerList(){
        int n = 1;
        for (Player myPlayer : playerList){
            System.out.println("Player "+n+ ": "+myPlayer.getNama());
            System.out.println("Jumlah Kartu: "+ myPlayer.getNumOfCard());
            if(myPlayer.equals(getPlayerInTurn())) System.out.println("Sedang giliran");
            else System.out.println("Tidak sedang giliran");
            System.out.println();
            n++;
        }
    }

    public void printPlayerInTurn(){
        System.out.print("Saat ini giliran Player : ");
        System.out.println(getPlayerInTurn().getNama());
        System.out.print("Selanjutnya giliran Player : ");
        if (reversed) {
            if (playerTurnIdx == 0) {
                System.out.println(playerList.get(playerList.size()-1).getNama());
            }
            else {
                System.out.println(playerList.get(playerTurnIdx-1).getNama());
            }
        }
        else {
            if (playerTurnIdx == playerList.size() - 1) {
                System.out.println(playerList.get(0).getNama());
            } 
            else {
                System.out.println(playerList.get(playerTurnIdx+1).getNama());
            }
        }
    }

}
