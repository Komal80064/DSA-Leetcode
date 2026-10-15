class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        // Approach - 01
        // for(int  i = 0; i < n;i++){
        //     Set<Integer> s = new HashSet<>();
        //     for(int j = i; j < n;j++){
        //         s.add(nums.get(j));
        //         int dist = s.size();
        //         ans += dist*dist;
        //     }
        // }

        // Approach - 02
        for(int i =0; i<n;i++){
            boolean[] seen = new boolean[101];
            int dist = 0;
            for(int j = i; j < n;j++){
                int num = nums.get(j);
                if(!seen[num]){
                    seen[num] = true;
                    dist++;
                }
                ans += dist*dist;
            }
        }
        return ans;
    }
}