public interface CardMethod {
    boolean isLegalMove(Card card);
    String toString();
    boolean isEqual(Card card);
}