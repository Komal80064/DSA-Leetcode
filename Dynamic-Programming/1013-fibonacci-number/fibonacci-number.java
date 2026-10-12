class Solution {
    public int fib(int n) {
        // ***Bottom up Approach****
        // if(n == 0) return 0;
        // int[] dp = new int[n+1];
        // dp[0] = 0;
        // dp[1] = 1;
        // for(int i = 2;i<=n;i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // return dp[n];

        //Top down Approach****
        int[] dp = new int[n+1];
        return fibo(n,dp);
    }
    private int fibo(int n, int[] dp){
        if(n <= 1) return n;

        if(dp[n] != 0) return dp[n];
        return dp[n] = fibo(n-1,dp) + fibo(n-2, dp);
    }
}