/**
 * Card
 */ 
public class Card {
    protected CardColor warnaKartu;

    public Card(CardColor warnaKartu){
        this.warnaKartu = warnaKartu;
    }

    public CardColor getColor(){
        return this.warnaKartu;
    }

}
