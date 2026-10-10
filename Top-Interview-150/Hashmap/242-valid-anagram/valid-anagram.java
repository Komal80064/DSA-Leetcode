class Solution {
    public boolean isAnagram(String s, String t) {

        //*****Approach - 01(Using frequency Array)*****
        // int[] freq = new int[26];
        // for(int i = 0;i < s.length();i++){
        //     freq[s.charAt(i)-'a']++;
        //     freq[t.charAt(i)-'a']--;
        // }
        
        // for(int i = 0;i < t.length();i++){
        //     if(freq[i] != 0)return false;
        // }
        // return true;

        // ****Approach - 02 (Using HashMap)
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : t.toCharArray()){
            if(!map.containsKey(c)) return false;

            map.put(c, map.get(c)-1);

            if(map.get(c) == 0){
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}