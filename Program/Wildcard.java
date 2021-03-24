/**
 * Wildcard.java
 */

public class Wildcard extends AbstractCard {

    // Constructor
    public Wildcard(CardColor color){
        super(CardType.Wild, color);    
    }

    @Override
    public boolean equals(Object o) {
        // Wildcard dapat dikeluarkan kapanpun
        return o != null;
    }

    @Override
    public String toString() {
        return getType() + " " + getColor();
    }
}