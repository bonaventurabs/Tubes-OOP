/**
 * Contoh.java
 * [Kelas Contoh sebagai contoh, pinjem buat ngetes list hehe]
 */

import java.util.ArrayList;

public class Contoh{
    /**
     * Constructor Contoh
     */
    public Contoh() {
    
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.remove(Integer.valueOf(2));
        test.remove(2);
        System.out.println(test);
        System.out.println(test.get(2));
        test.remove(2);
        System.out.println(test.get(2));
        System.out.println(test);
    }
}