public abstract class AbstractCard implements Card{
    private final CardType type;
    private final CardColor color;

    protected AbstractCard(CardType type, CardColor color) {
        this. type = type;
        this.color = color;
    }

    public CardType getType() {
        return type;
    }

    public CardColor getColor() {
        return color;
    }

    public abstract boolean equals(Object o);

    public abstract String toString();
}
