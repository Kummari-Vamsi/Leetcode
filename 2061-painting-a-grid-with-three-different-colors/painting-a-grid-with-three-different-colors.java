import java.util.*;

class Solution {
    private final int MOD = (int) 1e9+7;
    List<int[]> possList;
    public int colorTheGrid(int m, int n) {
        possList = new ArrayList<>();

        generatePoss(m, 0, 0, new int[m]);
        
        m = possList.size();
        int[][] dp = new int[n][m];

        for(int[] it : dp){
            Arrays.fill(it, -1);
        }
        
        int ans = 0;

        for(int i = 0;i < m;i++){
            ans += f(dp, 1, i, n, m);
            ans %= MOD;
        }

        return ans%MOD;
    }

    private int f(int[][] dp, int i, int j, int n, int m){
        if(i == n){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = 0;

        for(int k = 0;k < m;k++){
            if(cond(k, j)){
                ans += f(dp, i+1, k, n, m);
                ans %= MOD;
            }
        }

        return dp[i][j] = ans%MOD;
    }

    private boolean cond(int x, int y){
        int n = possList.get(x).length;

        for(int i = 0;i < n;i++){
            if(possList.get(x)[i] == possList.get(y)[i]){
                return false;
            }
        }
        return true;
    }

    private void generatePoss(int m, int prev, int idx, int[] nums){
        if(idx == m){
            possList.add(Arrays.copyOf(nums, m));
            return ;
        }

        for(int i = 1;i < 4;i++){
            if(i != prev){
                nums[idx] = i;
                generatePoss(m, i, idx+1, nums);
                nums[idx] = 0;
            }
        }
    }
}