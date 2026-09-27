class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] link = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(') st.push(i);
            else if(s.charAt(i) == ')'){
                link[i] = st.pop();
                link[link[i]] = i;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0, dir = 1; i < n ; i+= dir){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                i = link[i];
                dir = -dir;
            }else ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}