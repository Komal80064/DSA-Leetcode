class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        String[] map = {"", "", "abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};
        
        backtrack(digits, 0, new StringBuilder(), res, map);
        
        return res;        
    }

    private void backtrack(String digits, int idx, StringBuilder comb, List<String> res, String[] map) {
        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }
        
        String letters = map[digits.charAt(idx)-'0'];
        for (char letter : letters.toCharArray()) {
            comb.append(letter);
            backtrack(digits, idx + 1, comb, res, map);
            comb.deleteCharAt(comb.length() - 1);
        }
    }    
}