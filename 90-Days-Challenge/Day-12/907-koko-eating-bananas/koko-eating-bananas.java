class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r =0;
        for(int pile : piles){
            r = Math.max(r, pile);
        }

        while(l<=r){
            int mid = (l+r)/2;
            if(canEat(mid, piles , h)){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean canEat(int mid, int[] piles, int h){
        int hours = 0;
        for(int pile : piles){
            hours += (pile + mid-1)/mid;
            if(hours > h) return false;
        }
        return true;
    }
}