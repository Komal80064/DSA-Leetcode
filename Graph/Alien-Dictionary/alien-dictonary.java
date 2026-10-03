class Solution {
    public String findOrder(String[] words) {
        // code here
        int n = words.length;
        
        // Adj list for this problem
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 26 ; i++) adj.add(new ArrayList<>());
        
        // Find which characters actually exist
        boolean[] exists = new boolean[26];
        for(String word : words){
            for(char c : word.toCharArray()){
                exists[c - 'a'] = true;;
            }
        }
        
        int[] inDegree = new int[26];
        for(int i = 0; i < n-1; i++){
            String str1 = words[i];
            String str2 = words[i+1];
            int j = 0;
            
             // Find first different character
            while(j < str1.length() && j < str2.length() && str1.charAt(j) == str2.charAt(j)) j++;
            
            // for contidion like "cde" and "cdef", we have no character to comaprision in str1
            if(j == str1.length()){
                continue;
            }
            
            adj.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
            inDegree[str2.charAt(j) - 'a']++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < 26 ; i++){
            if(inDegree[i] == 0 && exists[i])q.offer(i);
        }
        
        
        // Topological sort
        StringBuilder result = new StringBuilder();
        while(!q.isEmpty()){
            int u = q.poll();
            result.append((char)(u + 'a'));
            
            for(int v : adj.get(u)){
                inDegree[v]--;
                if(inDegree[v] == 0) q.offer(v);
            }
        }
        
        // find cycle
        for(int i = 0 ; i < 26; i++){
            if(exists[i] && inDegree[i] != 0) return "";
        }
        
        return result.toString();
    }
}
