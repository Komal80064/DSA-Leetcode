class Solution {
    public int maxProduct(int[] nums) {
        int maxPro = nums[0];
        int minPro = nums[0];
        int ans = nums[0];

        for(int  i = 1; i < nums.length; i++){
            int num = nums[i];
            if(num < 0){
                int temp = maxPro;
                maxPro = minPro;
                minPro = temp;
            }
            maxPro = Math.max(num, maxPro*num);
            minPro = Math.min(num, minPro*num);

            ans = Math.max(ans, maxPro);
        }
        return ans;
    }
}