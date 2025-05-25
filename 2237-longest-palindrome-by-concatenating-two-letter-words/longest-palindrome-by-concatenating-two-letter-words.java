import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        int length = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        for (String word : count.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (!word.equals(reversed)) {
                if (count.containsKey(reversed)) {
                    int pairs = Math.min(count.get(word), count.get(reversed));
                    length += pairs * 4;
                    count.put(word, count.get(word) - pairs);
                    count.put(reversed, count.get(reversed) - pairs);
                }
            } else {
                int pairs = count.get(word) / 2;
                length += pairs * 4;
                count.put(word, count.get(word) - pairs * 2);
                if (!hasMiddle && count.get(word) > 0) {
                    // One palindrome word can go in the middle
                    length += 2;
                    hasMiddle = true;
                }
            }
        }

        return length;
    }
}
