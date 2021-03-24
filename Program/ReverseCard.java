import java.util.Objects;

public class ReverseCard extends AbstractCard{
    
    public ReverseCard(CardColor color) {
        super(CardType.Reverse, color);

        CardUtil.validateActionType(CardType.Reverse);
        CardUtil.validateColor(color);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReverseCard that = (ReverseCard) o;
        return getType() == that.getType() || getColor() == that.getColor();
    }

    public String toString() {
        return getType()+ " " + getColor();
    }
}
