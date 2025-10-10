public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (String s : strs)
            while (s.indexOf(prefix) != 0)  //check first string is same or not
                prefix = prefix.substring(0, prefix.length() - 1); //if not then reduce length of prefix string
        return prefix;
    }
}
