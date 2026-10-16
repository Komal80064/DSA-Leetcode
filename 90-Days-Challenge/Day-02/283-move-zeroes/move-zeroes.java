class Solution {
    public void moveZeroes(int[] nums) {
        int first = 0;
        for(int sec = 0;sec< nums.length;sec++){
            if(nums[sec] != 0){
                int temp = nums[first];
                nums[first++] = nums[sec];
                nums[sec] = temp;
            } 
        }
    }
}