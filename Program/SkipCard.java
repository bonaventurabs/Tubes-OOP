import java.util.Objects;

public class SkipCard extends AbstractCard{
    
    public SkipCard(CardColor color) {
        super(CardType.Skip, color);

        CardUtil.validateActionType(CardType.Skip);
        CardUtil.validateColor(color);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkipCard that = (SkipCard) o;
        return getType() == that.getType() || getColor() == that.getColor();
    }

    public String toString() {
        return getType() + " " + getColor();
    }
}
