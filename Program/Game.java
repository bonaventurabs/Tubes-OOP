/**
 * Game.java
 * [Class Game]
 */

import java.util.*;

public class Game {


    private Card discardPile;
    private int multipleDiscard = 0;
    private final List<Player> playerList;
    private int playerTurnIdx;
    private boolean reversed;
    private final Deck deck;

    /**
     * Constructor Game
     */
    public Game (List<Player> playerList, Card discardPile, Deck deck){
        this.playerList = playerList;
        this.discardPile = discardPile;
        this.deck = deck;
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
     * Method turn pertama / start game
     */
    public void startGame(){
        randomTurn();
        setDiscardPile(deck.gettopCard());
        deck.moveCardtoPlayer();
        playerTurnIdx = 0;
        reversed = false;
    }

    /**
     * Method turn selanjutnya
     */
    public void nextTurn() {
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

    /**
     * Getter discard pile
     */
    public Card getDiscardPile(){
        return discardPile;
    }
    public int getMultipleDiscard(){
        return multipleDiscard;
    }

    public void setMultipleDiscard(int multipleDiscard){
        this.multipleDiscard = multipleDiscard;
    }
}
