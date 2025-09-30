class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        // Using for loop****************
        // for(int size=n; size>1;size--){
        //     for(int i=0;i<size-1;i++){
        //         nums[i]=(nums[i]+nums[i+1])%10;
        //     }
        // }
        // return nums[0];
        // *******************************

        // Using while loop*******************
        while (n > 1) { // keep shrinking until only one number left
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--; // effectively the array shrinks by one
        }

        return nums[0];
    }
}
