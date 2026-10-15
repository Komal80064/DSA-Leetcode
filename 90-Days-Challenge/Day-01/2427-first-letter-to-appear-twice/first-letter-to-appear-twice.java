class Solution {
    public char repeatedCharacter(String s) {
        List<Character> list = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(list.contains(c)) return c;
            list.add(c);
        }
        return 'a';
    }
}