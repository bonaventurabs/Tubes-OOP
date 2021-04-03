/**
 * Game.java
 * [Class Game]
 */

import java.util.*;
//import kartu.*;

public class Game {

    private final List<Player> playerList;
    private int playerTurnIdx;
    private boolean reversed;

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

    public Player getPlayerInTurn(){
        return playerList.get(playerTurnIdx);    
    }

    public void printPlayerList(){
        int n = 1;
        for (Player myPlayer : playerList){
            System.out.println("Player "+n+ ": "+myPlayer.getNama());

            n++;
        }
    }

    public boolean getReversed(){
        return reversed;
    }

}
