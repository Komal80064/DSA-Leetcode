class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer>stack = new Stack<>();
        int n = arr.length;
        long mod = 1000000007;
        long res = 0;

        for(int i = 0; i<=n; i++){
            while(!stack.isEmpty() && (i==n || arr[stack.peek()] >arr[i])){
                int mid = stack.pop();
                int left = stack.isEmpty() ? mid+1 : mid - stack.peek();
                int right = i-mid;
                res += (long)arr[mid] * left * right;
                res %= mod;
            }
            stack.push(i);

        }
        return (int)res;

        
    }
}
