class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int j = 0;
        for(int i = 0; i< nums.length;i++){
            sum += nums[i];
            while(sum >= target){
                minLen = Math.min(minLen, i-j+1);
                sum -= nums[j++];
            }
        }
        return minLen== Integer.MAX_VALUE ? 0 : minLen;
    }
}