class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        int freq[] = new int[128];

        for(char c : t.toCharArray()){
            freq[c]++;
        }

        int required = t.length();
        int left =0, right = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        while(right < s.length()){
            char c = s.charAt(right);
            if(freq[c] > 0) required--;
            freq[c]--;
            right++;

            while(required == 0){
                if(right-left < minLen){
                    minLen = right-left;
                    start = left;
                }

                char ch = s.charAt(left);
                freq[ch]++;
                if(freq[ch] > 0)required++;
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}