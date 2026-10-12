class Solution {
    public int fib(int n) {
        // ****Space optimization****
        if(n <= 1) return n;
        int prev2 = 0;
        int prev1 = 1;
        int curr = 0;
        for(int i = 2; i <= n; i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;

        // ****Bottom up Approach****
        // if(n == 0) return 0;
        // int[] dp = new int[n+1];
        // dp[0] = 0;
        // dp[1] = 1;
        // for(int i = 2;i<=n;i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // return dp[n];

        //****Top down Approach****
        // int[] dp = new int[n+1];
        // return fibo(n,dp);
    }
    // private int fibo(int n, int[] dp){
    //     if(n <= 1) return n;

    //     if(dp[n] != 0) return dp[n];
    //     return dp[n] = fibo(n-1,dp) + fibo(n-2, dp);
    // }
}