import java.util.Objects;
/*
 * NumberCard
 */
public class NumberCard extends AbstractCard {
    private final int value;

    public NumberCard(int value, CardColor color) {
        super(CardType.Number, color);

        CardUtil.validateColor(color);

        CardUtil.validateNumber(value);
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberCard that = (NumberCard) o;
        return value == that.value || getColor() == that.getColor();
    }

    public String toString() {
        return value + " " + getColor();
    }
}