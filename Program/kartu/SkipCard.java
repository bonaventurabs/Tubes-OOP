/**
 * SkipCard.java
 * Kelas SkipCard sebagai jenis kartu Skip
 * 
 */

package kartu;

public class SkipCard extends Card implements CardMethod {

    /**
     * Constructor SkipCard
     */
    public SkipCard(CardColor warnaKartu) {
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
        return ((card instanceof SkipCard) && card.getColor() == this.getColor());
    }

    /**
     * isLegalMove
     * SkipCard dapat dikeluarkan dengan syarat: 
     * kartu yang dimainkan sebelumnya adalah kartu SkipCard 
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