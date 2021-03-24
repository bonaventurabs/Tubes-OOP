/**
 * DrawTwoCard.java
 */

public class DrawTwoCard extends AbstractCard {
    public CardColor color;

    // Constructor
    public DrawTwoCard (CardColor color) {
        super(CardType.DrawTwo, color);
        CardUtil.validateColor(color);
    }

    @Override
    public boolean equals (Object o) {
        // cek apakah objeknya sama
        if (this == o) {
            return true;
        }
        // cek apakah objeknya null
        if (o == null) {
            return false;
        }
        // cek apakah memiliki tipe yang sama
        if (o instanceof DrawTwoCard) {
            return true;
        }
        // casting
        DrawTwoCard other = (DrawTwoCard) o;
        // cek apakah berwarna sama
        return (this.getColor() == other.getColor());
    }

    @Override
    public String toString() {
        return getType() + " " + getColor();
    }
}