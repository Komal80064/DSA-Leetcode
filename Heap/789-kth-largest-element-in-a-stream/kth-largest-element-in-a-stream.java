class KthLargest {
    PriorityQueue<Integer> minHeap;
    int size;
    public KthLargest(int k, int[] nums) {
        size = k;
        minHeap = new PriorityQueue<>();

        for(int num : nums){
            // minHeap.offer(num);
            // if(minHeap.size() > k) minHeap.poll();

            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if(minHeap.size() > size) minHeap.poll();

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */