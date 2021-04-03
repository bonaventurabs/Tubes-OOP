/**
 * ReverseCard.java
 * Kelas ReverseCard sebagai jenis kartu Reverse
 * 
 */

package kartu;

public class ReverseCard extends Card implements CardMethod {

    /**
     * Constructor ReverseCard
     */
    public ReverseCard(CardColor warnaKartu) {
        super(warnaKartu);
    }

    /**
     * Getter warnaKartu
     */
    public CardColor getColor() {
        return this.warnaKartu;
    }

    /**
     * toString
     * Mengubah dalam format String
     */
    public String toString() {
        return getClass() + " " + getColor();
    }

    /**
     * isEqual
     * Mengecek apakah kartu sama persis
     * Kartu sama persis jika memiliki warna dan jenis kartu yang sama
     * @param Kartu yang sedang dimiliki
     * @return true jika memiliki warna dan jenis kartu yang sama
     */
    public boolean isEqual(Card card) {
        // TODO Auto-generated method stub
        return ((card instanceof ReverseCard) && card.getColor() == this.getColor());
    }

    /**
     * isLegalMove
     * ReverseCard dapat dikeluarkan dengan syarat: 
     * kartu yang dimainkan sebelumnya adalah kartu ReverseCard 
     * atau berwarna sama
     * atau jika kartu yang dimainkan sebelumnya adalah Wildcard dengan warna pilihan yang berwarna sama.
     * @param Kartu yang dimainkan sebelumnya
     * @return true jika memenuhi syarat
     */
    public boolean isLegalMove(Card card) {
        // TODO Auto-generated method stub
        return ((card.getClass() == this.getClass()) || (card.getColor() == this.getColor()) || ((card instanceof Wildcard) && ((Wildcard) card).nextWarna == this.getColor()));
    }
    
}