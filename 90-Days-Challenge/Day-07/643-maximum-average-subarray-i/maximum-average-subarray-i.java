class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length < k) return 0;
        int sum = 0;
        double avg = Integer.MIN_VALUE;
        int j = 0;
        for(int i = 0;i<k-1;i++) sum += nums[i];
        for(int i=k-1;i<nums.length;i++){
            sum += nums[i];
            avg = Math.max(avg, (double)sum/k);
            sum -= nums[j++];
        }
        return avg;        
    }
}