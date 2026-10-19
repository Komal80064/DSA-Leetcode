class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int small = 0;
        int same = 0;
        for(int num : nums){
            if(num < target) small++;
            else if(num == target ) same++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<same;i++){
            ans.add(small+i);
        }
        return ans;
    }
}