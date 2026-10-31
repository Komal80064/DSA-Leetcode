class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), res, s);
        return res;
    }
    private void backtrack(int start, List<String>curr, List<List<String>> res, String s){
        if(start == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i< s.length();i++){
            if(isPalindrome(s,start,i)){
                //Pick
                curr.add(s.substring(start,i+1));
                // Explore
                backtrack(i+1, curr, res, s);
                // Backtrack
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean isPalindrome(String sub,int l, int r){
        while(l<r){
            if(sub.charAt(l) != sub.charAt(r)) return false;
            r--;
            l++;
        }
        return true;
    }
}