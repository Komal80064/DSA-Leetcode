class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Using HashMap
        // Map<Character, Integer> map = new HashMap<>();

        // for(char c : magazine.toCharArray()){
        //     map.put(c, map.getOrDefault(c,0)+1);
        // }

        // for(char c : ransomNote.toCharArray()){
        //     if(!map.containsKey(c)) return false;
        //     map.put(c, map.getOrDefault(c,0)-1);
        //     if(map.get(c) == 0) map.remove(c);
        // }
        // return true;

        // Using frequency Array
        int[] freq = new int[26];
        for(char c : magazine.toCharArray()) freq[c-'a']++;
        
        for(char c : ransomNote.toCharArray()){
            if(freq[c-'a'] <= 0) return false;
            freq[c-'a']--;
        }
        return true;
    }

}