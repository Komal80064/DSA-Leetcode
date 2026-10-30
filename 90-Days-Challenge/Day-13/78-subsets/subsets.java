class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), result, nums);
        return result;
    }
    private void backtrack(int start, List<Integer> curr, List<List<Integer>> result, int[] nums){
        result.add(new ArrayList<>(curr));
        for(int i = start; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(i+1, curr, result, nums);
            curr.remove(curr.size() -1);
        }
    }
}