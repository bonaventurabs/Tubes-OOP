/**
 * Game.java
 * [Class Game]
 */

import java.util.*;

public class Game {

    private Player[] playerList;
    private Card discardPile;
    private int multipleDiscard;

    Scanner scan = new Scanner(System.in);

    /**
     * Constructor Game
     * @Param numPlayer
     */
    public Game (int numPlayer){

        // Set player
        for (int i=0; i<numPlayer; i++){
            String nama = scan.nextLine();
            playerList[i] = new Player(nama);
        }

        // Set deck
        Deck deck = new Deck();

        // Random list player
        Collections.shuffle(playerList);

        // Random kartu awal di discard pile
        Card tmp = deck.gettopCard();
        while (!(tmp instanceof NumberCard)){
            deck.randomCard();
            tmp = deck.gettopCard();
        }
        discardPile = deck.gettopCard();

    }

    /**
     * Method player pertama
     */
    public void firstTurn(){

    }

    /**
     * Method turn selanjutnya
     */
    public void nextTurn(){

    }

}
