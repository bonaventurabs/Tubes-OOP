/**
 * Game.java
 * [Class Game]
 */

import java.util.*;

public class Game {


    private Card discardPile;
    private int multipleDiscard;
    private Player[] playerList;
    private int playerTurnIdx = 0;
    private boolean reversed = false;

    /**
     * Constructor Game
     * @Param numPlayer
     */
    public Game (Player[] playerList, Card discardPile){
        this.playerList = playerList;
        this.discardPile = discardPile;
    }

    /**
     * Method set discardPile
     */
    public void setDiscardPile(Card discardPile){
        this.discardPile = discardPile;
    }

    /**
     * Method ngacak turn awal
     */
    public void randomTurn(){
        Collections.shuffle(playerList);
    }

    /**
     * Method turn selanjutnya
     */
    public void nextTurn(){

    }

}
