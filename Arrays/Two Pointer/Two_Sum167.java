class Solution {
    public int[] twoSum(int[] nums, int target) {
        int first = 0;
        int last = nums.length -1;

        while(first<last){
            int sum = nums[first] + nums[last];
            if(sum == target) return new int[]{first+1, last+1};
            else if(sum>target) last--;
            else first++;
        }
        return new int[0];

    }
}
