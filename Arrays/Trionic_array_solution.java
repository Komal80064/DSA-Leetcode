class Solution {
    public boolean isTrionic(int[] nums) {
        int n  = nums.length;
        int peak = 0;
        while(peak<n-1 && nums[peak]<nums[peak+1]) peak++;
        if(peak==0) return false;

        int valley = peak;
        while(valley < n-1 && nums[valley] > nums[valley+1]) valley++;
        if(valley == peak || valley == n-1) return false;


        for(int i = valley; i<n-1;i++){
            if(nums[i]>=nums[i+1]) return false;
        }
        return true;
    }
}
