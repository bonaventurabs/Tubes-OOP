/**
 * Deck.java
 * [Kelas Deck menyimpan list of Card]
 */
import java.util.*; 

public class Deck {
    private List<Card> deckCard = new ArrayList<Card>();
    private List<Card> playerCard = new ArrayList<Card>();

    /**
     * Constructor Deck
     */
    public Deck() {
        List<CardColor> colorList = new ArrayList<>();
        color.add(CardColor.Merah);
        color.add(CardColor.Hijau);
        color.add(CardColor.Kuning);
        color.add(CardColor.Biru);
        for (CardColor color : colorList) {
            this.deckCard.add(new NumberCard(0, color));
            this.deckCard.add(new NumberCard(1, color));
            this.deckCard.add(new NumberCard(2, color));
            this.deckCard.add(new NumberCard(3, color));
            this.deckCard.add(new NumberCard(4, color));
            this.deckCard.add(new NumberCard(5, color));
            this.deckCard.add(new NumberCard(6, color));
            this.deckCard.add(new NumberCard(7, color));
            this.deckCard.add(new NumberCard(8, color));
            this.deckCard.add(new NumberCard(9, color));
            this.deckCard.add(new SkipCard(color));
            this.deckCard.add(new SkipCard(color));
            this.deckCard.add(new ReverseCard(color));
            this.deckCard.add(new ReverseCard(color));
            this.decCard.add(new DrawTwoCard(color));
            this.decCard.add(new DrawTwoCard(color));
        }
        for (int i = 0; i < 4; i++) {
            this.decCard.add(new DrawFourCard(CardColor.Wild));
            this.decCard.add(new Wildcard(CardColor.Wild));
        }
    }

    /**
     * Mengacak isi list Card dalam Deck
     */
    public void randomCard() {
        Collections.shuffle(deckCard);
    }

    /**
     * Memindahkan Card teratas pada deckCard ke playerCard
     */
    public void moveCardtoPlayer() {
        playerCard.add(this.gettopCard());
        deckCard.remove(this.gettopCard());
    }

    /**
     * Memindahkan Card dari Player ke deckCard
     * @param movedCard objeck Card
     */
    public void moveCardtoDeck(Card movedCard) {
        deckCard.add(movedCard);
        playerCard.remove(movedCard);
    }

    /**
     * Getter topCard
     * yaitu indeks-0 dari Arraylist deckCard
     */
    public Card gettopCard() {
        return deckCard.get(0);
    }
}