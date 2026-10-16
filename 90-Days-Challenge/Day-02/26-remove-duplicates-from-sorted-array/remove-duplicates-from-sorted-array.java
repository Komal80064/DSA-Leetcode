class Solution {
    public int removeDuplicates(int[] nums) {
        int first = 1;
        for(int sec=1;sec<nums.length;sec++){
            if(nums[sec] != nums[sec-1]){
                nums[first] = nums[sec];
                first++;
            }
        }
        return first;
    }
}