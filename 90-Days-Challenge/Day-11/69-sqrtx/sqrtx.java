class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int r = x/2;
        int l = 1;
        while(l<=r){
            int mid = (r+l)/2;
            long sqr = (long)mid * mid;
            if(sqr==x) return mid;
            else if(sqr < x){
                l= mid+1;
            }else r = mid-1;
        }
        return r;
    }
}