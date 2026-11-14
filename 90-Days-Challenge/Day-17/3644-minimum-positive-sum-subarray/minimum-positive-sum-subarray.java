class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        
        int min = Integer.MAX_VALUE;
        for(int size = l; size <= r; size++) {
            
            int sum = 0;
            for(int i = 0; i < size; i++) {
                sum += nums.get(i);
            }
            if(sum > 0 && sum < min) {
                min = sum;
            }

            for(int i = size; i < nums.size(); i++) {
                sum -= nums.get(i - size);
                sum += nums.get(i);
                if(sum > 0 && sum < min) {
                    min = sum;
                }
            }
        }

        return min != Integer.MAX_VALUE
                    ? min
                    : -1;
    }
}