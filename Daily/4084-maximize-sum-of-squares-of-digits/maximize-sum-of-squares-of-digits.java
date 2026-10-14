class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num*9 < sum) return "";
        int nines = sum/9;
        int rest = sum % 9;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nines;i++) sb.append('9');
        if(rest > 0) sb.append(rest);
        while(sb.length() < num) sb.append('0');
        return sb.toString();
    }
}