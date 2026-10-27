class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstPos(nums, target);
        if(first == -1) return new int[]{-1,-1};
        int right = lastPos(nums, target);
        return new int[]{first, right};
    }
    private int firstPos(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        int first = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                first = mid;
                r = mid-1;
            }else if(nums[mid] > target) r = mid-1;
            else l = mid+1;
        }
        return first;
    }
    private int lastPos(int[] nums, int target){
        int l =0;
        int r = nums.length-1;
        int last = 0;
        while(l<=r){
            int mid  = (l+r)/2;
            if(nums[mid] == target){
                last = mid;
                l = mid+1;
            }else if(nums[mid] > target) r = mid -1;
            else l =mid+1;
        }
        return last;
    }
}