class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> d = new HashMap<>();
        for(List<String> l : knowledge){
            d.put(l.get(0), l.get(1));
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                int j = s.indexOf(')' , i+1);
                str.append(d.getOrDefault(s.substring(i+1, j), "?"));
                i = j;
            }else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}