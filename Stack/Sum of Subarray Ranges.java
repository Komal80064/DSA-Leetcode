class Solution {
    public long subArrayRanges(int[] nums) {
        return getMax(nums) - getMin(nums);
    }
    private long getMin(int[] arr){
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for(int i =0;i<=arr.length;i++){
            while(!stack.isEmpty() && (i == arr.length || arr[stack.peek()] > arr[i])){
                int mid = stack.pop();
                int left = stack.isEmpty() ? mid+1 : mid-stack.peek();
                int right = i-mid;
                sum += (long)arr[mid] * left * right;
            }
            stack.push(i);
        }
        return sum;
    }

    private long getMax(int[] arr){
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for(int i = 0 ; i<=arr.length;i++){
            while(!stack.isEmpty() && (i == arr.length || arr[stack.peek()] < arr[i])){
                int mid = stack.pop();
                int left = stack.isEmpty() ? mid+1 : mid-stack.peek();
                int right = i-mid;
                sum += (long)arr[mid] * left * right;
            }
            stack.push(i);
        }
        return sum;
    }
}
