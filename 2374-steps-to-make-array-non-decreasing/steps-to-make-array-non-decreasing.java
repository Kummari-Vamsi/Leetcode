class Solution {
    public int totalSteps(int[] A) {
        int n = A.length, res = 0;
        int dp[] = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            // take [1,5,4,1,2,3] as example, the 4 will erase [1, 2, 3]. At the same time, 5 will erase 4, so after 5 erasing 4, and 4 erasing 1, then the 5 will continue to erase [2, 3], so the total number of max erase is the number of [1, 2, 3]
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                dp[i] = Math.max(dp[i] + 1, dp[stack.poll()]);
                res = Math.max(res, dp[i]);
            }
            stack.push(i);
        }
        return res;
    }
}