class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int r = 0;

        for(char c: s.toCharArray()){
            if(c == ')') depth--;
            else if(c != '(') continue;
            else{
                depth++;
                r = Math.max(r, depth); // for count max depth of parantheses
            }
        }

        return r;
    }
}