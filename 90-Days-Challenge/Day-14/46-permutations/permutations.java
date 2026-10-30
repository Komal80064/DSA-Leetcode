class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), result, nums);
        return result;
    }
    private void backtrack(List<Integer>list, List<List<Integer>> result, int[] nums){
        if(nums.length == list.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrack(list, result, nums);
            list.remove(list.size()-1);
        }
    }

}
