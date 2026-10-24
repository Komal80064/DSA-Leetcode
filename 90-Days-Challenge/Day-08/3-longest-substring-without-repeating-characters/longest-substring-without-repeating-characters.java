class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Queue<Character> ans = new LinkedList<>();
        int len = 0;
        for(char c : s.toCharArray()){
            while(ans.contains(c)) ans.poll();
            ans.add(c);

            len = Math.max(len, ans.size());
        }
        return len;
    }
}