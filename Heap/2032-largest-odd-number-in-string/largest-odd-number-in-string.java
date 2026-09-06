class Solution {
    public String largestOddNumber(String num) {
        int lastIdx = -1;

        for(int i = num.length()-1;i>=0;i--){
            if((num.charAt(i) - '0') % 2 == 1){
                lastIdx = i;
                break;
            }
        }

        if(lastIdx == -1) return "";

        int i = 0;
         while (i <= lastIdx && num.charAt(i) == '0') i++;
        return num.substring(i, lastIdx+1);
    }
}