import java.util.Objects;
/*
 * NumberCard
 */
public class NumberCard extends AbstractCard {
    private final int value;

    /*
     * Constuctor
     */
    public NumberCard(int value, CardColor color) {
        super(CardType.Number, color);

        CardUtil.validateColor(color);

        CardUtil.validateNumber(value);
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        /* 
         * checking if both the object references are
         * referring to the same object
         */
        if (this == o) 
            return true;

        /* 
         * it checks if the argument is of the type NumberCard
         * by comparing the classes of the passed argument and this object 
         */
        if (o == null || getClass() != o.getClass())
            return false;

        /* 
         * type casting of the argument 
         */
        NumberCard that = (NumberCard) o;

        /* 
         * comparing the state of argument with the state of 'that' Object 
         */
        return value == that.value && getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        /* 
         * return value and color as a hashcode value 
         */
        return Objects.hash(value, getColor());
    }

    @Override
    public String toString() {
        /* 
         * change hashcode to string 
         */
        return value + " " + getColor();
    }
}