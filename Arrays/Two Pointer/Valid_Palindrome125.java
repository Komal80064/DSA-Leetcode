// class Solution {
//     public boolean isPalindrome(String s) {
//         s = s.toLowerCase().replaceAll("[^a-z0-9]","");
//         int left  = 0;
//         int right = s.length()-1;

//         while(left<right){
//             if(s.charAt(left) != s.charAt(right)){
//                 return false;
//             }
//             left++;
//             right--;
//         }
//         return true;
//     }
// }



class Solution {
    public boolean isPalindrome(String s) {
        //keep only alphanumericals somehow
        int left = 0, right = s.length() - 1;
        while(left <= right) {
             while (left < right && !alphaNum(s.charAt(left))) {
                left++;
            }
            while (left < right && !alphaNum(s.charAt(right))) {
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {return false;}
            left++;
            right--;
        }
        return true;
    }
    public boolean alphaNum (char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
