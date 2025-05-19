class Solution {
    public int totalSteps(int[] A) {
        int n = A.length, res = 0;
        int dp[] = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                dp[i] = Math.max(dp[i] + 1, dp[stack.poll()]);
                res = Math.max(res, dp[i]);
            }
            stack.push(i);
        }
        return res;
    }
}