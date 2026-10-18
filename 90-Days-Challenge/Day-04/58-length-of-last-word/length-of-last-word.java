class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length() - 1;
        while(s.charAt(n)==' ') n--;
        int ans=0;
        while(n>=0 && s.charAt(n) != ' '){
            ans++;
            n--;
        }
        return ans;
    }
}