/**
 * DrawFourCard.java
 */

public class DrawFourCard extends AbstractCard {

    // Constructor
    public DrawFourCard(CardColor color){
        super(CardType.DrawFour, color);
        CardUtil.validateColor(color);
    }

    @Override
    public boolean equals(Object o) {
        // DrawFour dapat dikeluarkan kapanpun
        return o != null;
    }

    @Override
    public String toString() {
        return getType() + " " + getColor();
    }
}