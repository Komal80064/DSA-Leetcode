class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for(int w : weights){
            l = Math.max(l,w);
            r += w;
        }

        while(l<=r){
            int mid = (l+r)/2;
            if(isValid(mid, weights, days)) r = mid-1;
            else l = mid+1;
        }
        return l;
    }

    private boolean isValid(int cap, int[] weights, int days){
        int day = 1;
        int curLoad = 0;
        for(int w : weights){
            if(curLoad + w > cap){
                day++;
                curLoad = 0;
            }
            curLoad += w;
            if(day > days) return false;
        }
        return true;
    }
}