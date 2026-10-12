class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        int[] tab = new int[n+1];
        tab[0] = 0;
        tab[1] = 1;
        for(int i = 2;i<=n;i++){
            tab[i] = tab[i-1] + tab[i-2];
        }
        return tab[n];
    }
}