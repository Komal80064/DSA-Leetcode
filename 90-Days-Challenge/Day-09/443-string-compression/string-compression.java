class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int len = 0;

        while(i < n){
            int count = 0;
            char current = chars[i];
            while(i < n && chars[i]== current){
                i++;
                count++;
            }
            chars[len++] = current;
            if(count>1){
                String st = String.valueOf(count);
                for(char ch : st.toCharArray()) chars[len++] = ch;
            }
        }
        return len;
    }
}