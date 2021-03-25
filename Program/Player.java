  
/**
 * Player.java
 * [Kelas Player] Masih banyak bingung 
 */

import java.util.Scanner;

public class Player extends Deck {
    public String nama;
    static int jumlahPlayer = 0;
    private List<Card> playerCardList = new ArrayList<Card>();//bingung ngisinya gimana

    public Player (String nama){  //Input nama nya kayanya di Main
        this.nama = nama;   
        jumlahPlayer ++;
    }

    public void Draw (){
        super.moveCardtoPlayer(); 
        topCard = super.playerCard.get(0); // karena playerCard yg di deck itu utk semua player, jadinya draw ambil dari list playerCard yg di deck
        playerCardList.add(topCard);
        super.playerCard.remove(0); 
    }
    public void Discard { //mindahin dari playerCardList ke deck
         topCard = playerCardList.get(0);
         super.deckCard.add(0);
         playerCardList.remove(0);
         super.moveCardtoDeck();
    }
    public void DeclareHIJI(){ // Masih ga tau bakal ngapain

    }
    public void getCard(){  // ini agak bingung gimana sebenarnya dapatin kartu dari list playerCard yg di Deck
        
        topCard = super.playerCard.get(0); // kartu kedua
        playerCardList.add(topCard);
        super.playerCard.remove(0);

        topCard = super.playerCard.get(0); // kartu ketiga 
        playerCardList.add(topCard);
        super.playerCard.remove(0);

        topCard = super.playerCard.get(0); // kartu keempat 
        playerCardList.add(topCard);
        super.playerCard.remove(0);

        topCard = super.playerCard.get(0); // kartu kelima
        playerCardList.add(topCard);
        super.playerCard.remove(0);

        topCard = super.playerCard.get(0); // kartu keenam
        playerCardList.add(topCard);
        super.playerCard.remove(0); 

        topCard = super.playerCard.get(0); //kartu ketujuh
        playerCardList.add(topCard);
        super.playerCard.remove(0);   
    }
}