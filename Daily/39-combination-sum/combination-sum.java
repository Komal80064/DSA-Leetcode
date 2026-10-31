class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), res, candidates, target);
        return res;
    }
    private void backtrack(int idx, List<Integer> curr, List<List<Integer>> res, int[] candi, int target){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        // If target becomes negative
        if(target < 0 || idx >= candi.length) return;

        curr.add(candi[idx]);
         // PICK: Reuse the same element
        backtrack(idx, curr, res, candi, target - candi[idx]);
        curr.remove(curr.size()-1);
        // NOT PICK: move to next element
        backtrack(idx+1, curr, res, candi, target);
    }
}