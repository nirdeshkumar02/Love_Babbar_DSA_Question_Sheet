package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class print_dublicate_character_in_string {
    static final int NO_OF_CHARS = 256;

    public static void main(String[] args) {
        String str = "test string";
        printDups(str);
    }



    // Using Map

    private static void printDups(String str) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!count.containsKey(str.charAt(i)))
                count.put(str.charAt(i), 1);
            else
                count.put(str.charAt(i), count.get(str.charAt(i)) + 1);
        }
        // Printing duplicates element.

        for (Map.Entry mapElement : count.entrySet()) {
            char key = (char) mapElement.getKey();
            int value = ((int) mapElement.getValue());

            if (value > 1)
                System.out.println(key + ", count = " + value);
        }



    /*   Using HASHING

    private static void printDups(String str) {
        int count[] = new int[NO_OF_CHARS];
        fillCharCounts(str, count);

        for (int i = 0; i < NO_OF_CHARS; i++)
            if (count[i] > 1)
                System.out.println((char)(i) + ", count = " + count[i]);
    }

    private static void fillCharCounts(String str, int[] count) {
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
    }

     */

    }
}
