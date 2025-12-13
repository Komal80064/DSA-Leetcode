class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])) //set not contain duplicate value
            return true;
    }
    return false;
}
}
