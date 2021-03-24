public class CardUtil {
    private CardUtil() {
        
    }

    public static void validateColor(CardColor color) {
        if (color == null) {
            throw new IllegalArgumentException("Warna kartu harus sesuai dengan yang tersedia");
        }
    }

    public static void validateNumber(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("Nomor kartu harus berada di rentang 0 sampai 9");
        }
    }

    public static void validateActionType(CardType type) {
        if (type == CardType.Skip || type == CardType.Reverse) {
            return;
        }
        throw new IllegalArgumentException("Invalid action type");
    }
}
