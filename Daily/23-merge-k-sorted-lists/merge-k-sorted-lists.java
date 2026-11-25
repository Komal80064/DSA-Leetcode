/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for(ListNode node : lists){
            if(node != null) pq.add(node);
        }    

        ListNode ans  = new ListNode(0);
        ListNode dummy = ans;

        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();

            dummy.next = smallest;
            dummy = dummy.next;

            if(smallest.next != null) pq.add(smallest.next);
        }    

        return ans.next;
    }
}