/**
 * Deck.java
 * [Kelas Deck menyimpan list of Card]
 */
import java.util.*; 

public class Deck {
    private Card topCard;
    private List<Card> deckCard = new ArrayList<Card>();
    private List<Card> playerCard = new ArrayList<Card>();

    /**
     * Constructor Deck
     */
    public Deck() {
        this.deckCard.add(new ReverseCard());
        this.deckCard.add(new ReverseCard());
        this.deckCard.add(new ReverseCard());
        this.deckCard.add(new ReverseCard());
        this.deckCard.add(new WildCard());
        this.deckCard.add(new WildCard());
        this.decCard.add(new DrawCard());
        this.decCard.add(new DrawCard());
        this.decCard.add(new DrawCard());
        this.decCard.add(new DrawCard());
        this.decCard.add(new DrawCard());
        this.decCard.add(new DrawCard());
        this.decCard.add(new SkipCard());
        this.decCard.add(new SkipCard());
        this.decCard.add(new SkipCard());
        this.decCard.add(new SkipCard());
        this.decCard.add(new NumberCard());
        this.decCard.add(new NumberCard());
        this.decCard.add(new NumberCard());
        this.decCard.add(new NumberCard());
        this.decCard.add(new NumberCard());
        this.decCard.add(new NumberCard());
        this.decCard.add(new NumberCard());
        this.decCard.add(new NumberCard());
        this.decCard.add(new NumberCard());
        this.decCard.add(new NumberCard());
        topCard = deckCard.get(0);
    }

    /**
     * Mengacak isi list Card dalam Deck
     */
    public void randomCard() {
        Collections.shuffle(deckCard);
        topCard = deckCard.get(0);
    }

    /**
     * Memindahkan Card teratas pada deckCard ke playerCard
     */
    public void moveCardtoPlayer() {
        playerCard.add(topCard);
        deckCard.remove(0);
        topCard = deckCard(0);
    }

    /**
     * Memindahkan Card dari Player ke deckCard
     * @param movedCard objeck Card
     */
    public void moveCardtoDeck(Card movedCard) {
        deckCard.add(movedCard);
        playerCard.remove(movedCard);
        topCard = deckCard(0);
    }

    /**
     * Getter topCard
     */
    public Card gettopCard() {
        return topCard;
    }
}