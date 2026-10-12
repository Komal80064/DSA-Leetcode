class Solution {
    // private int count(int i, int n, int[] dp){
    //     if(i == n) return 1;
    //     if(i > n) return 0;
    //     if(dp[i] != -1) return dp[i];
    //     return dp[i]= count(i+1,n,dp) + count(i+2,n,dp);
    // }
    public int climbStairs(int n) {
        if(n <= 3) return n;
        int[] dp = new int[n+2];
        Arrays.fill(dp,-1);
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4;i <= n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
        // return count(0,n, dp);
    }
}