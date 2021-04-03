/**
 * NumberCard.java
 * Kelas NumberCard sebagai jenis kartu nomor 0-9
 * 
 */

package kartu;

public class NumberCard extends Card implements CardMethod{
    final int nomor;

    /**
     * Constuctor Number Card
     */
    public NumberCard(int nomor, CardColor warnaKartu) {
        super(warnaKartu);
        this.nomor = nomor;
    }

    /**
     * Getter nomor
     */
    public int getValue(){
        return this.nomor;
    }

    /**
     * Constuctor warnaKartu
     */
    public CardColor getColor(){
        return this.warnaKartu;
    }

    /**
     * toString
     * Mengubah dalam format String
     */
    public String toString() {
        return getValue() + " " + getColor();
    }

    /**
     * isEqual
     * Mengecek apakah kartu sama persis
     * Kartu sama persis jika memiliki warna dan nomor kartu yang sama
     * @param Kartu yang sedang dimiliki
     * @return true jika memiliki warna dan nomor kartu yang sama
     */
    public boolean isEqual(Card card) {
        // TODO Auto-generated method stub
        return (getValue() == this.getValue() && card.getColor() == this.getColor());
    }

    /**
     * isLegalMove
     * NumberCard dapat dikeluarkan dengan syarat: 
     * kartu yang dimainkan sebelumnya memiliki nomor kartu yang sama 
     * atau berwarna sama
     * atau jika kartu yang dimainkan sebelumnya adalah Wildcard dengan warna pilihan yang berwarna sama.
     * @param Kartu yang dimainkan sebelumnya
     * @return true jika memenuhi syarat
     */
    public boolean isLegalMove(Card card) {
        // TODO Auto-generated method stub
        return ((((NumberCard)card).getValue() == this.getValue()) || (card.getColor() == this.getColor())
                || ((card instanceof Wildcard) && ((Wildcard) card).nextWarna == this.getColor()));
    }
}