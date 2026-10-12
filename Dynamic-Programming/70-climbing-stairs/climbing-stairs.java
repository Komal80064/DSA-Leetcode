class Solution {
    private int count(int i, int n, int[] dp){
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[i] != -1) return dp[i];
        return dp[i]= count(i+1,n,dp) + count(i+2,n,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        Arrays.fill(dp,-1);
        return count(0,n, dp);
    }
}