import java.util.Objects;
/*
 * ReverseCard
 */
public class ReverseCard extends AbstractCard{
    
    /*
     * Constuctor
     */
    public ReverseCard(CardColor color) {
        super(CardType.Reverse, color);

        CardUtil.validateActionType(CardType.Reverse);
        CardUtil.validateColor(color);
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
         * it checks if the argument is of the type ReverseCard
         * by comparing the classes of the passed argument and this object 
         */
        if (o == null || getClass() != o.getClass()) return false;
        
        /* 
         * type casting of the argument 
         */
        ReverseCard that = (ReverseCard) o;
        
        /* 
         * comparing the state of argument with the state of 'that' Object 
         */
        return getType() == that.getType() && getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        /* 
         * return type and color as a hashcode value 
         */
        return Objects.hash(getType(), getColor());
    }

    @Override
    public String toString() {
        /* 
         * change hashcode to string 
         */
        return getType()+ " " + getColor();
    }
}
