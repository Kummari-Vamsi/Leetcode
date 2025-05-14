import java.util.*;

public class Solution {
    static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> numsList) {
        int[] nums = new int[26];
        for (int i = 0; i < 26; i++) {
            nums[i] = numsList.get(i);
        }

        // Step 1: Build the transformation matrix (26 x 26)
        long[][] transform = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                transform[i][(i + j) % 26] = (transform[i][(i + j) % 26] + 1) % MOD;
            }
        }

        // Step 2: Convert string to frequency vector
        long[] freq = new long[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 3: Raise matrix to power t
        long[][] powerMatrix = matrixPower(transform, t);

        // Step 4: Multiply matrix with initial freq vector
        long[] finalFreq = new long[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                finalFreq[i] = (finalFreq[i] + powerMatrix[j][i] * freq[j]) % MOD;
            }
        }

        // Step 5: Sum all frequencies
        long result = 0;
        for (long val : finalFreq) {
            result = (result + val) % MOD;
        }

        return (int) result;
    }

    private long[][] matrixPower(long[][] base, int power) {
        int size = base.length;
        long[][] result = new long[size][size];

        // Initialize result as identity matrix
        for (int i = 0; i < size; i++) result[i][i] = 1;

        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiplyMatrices(result, base);
            }
            base = multiplyMatrices(base, base);
            power >>= 1;
        }

        return result;
    }

    private long[][] multiplyMatrices(long[][] a, long[][] b) {
        int size = a.length;
        long[][] res = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < size; j++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}
