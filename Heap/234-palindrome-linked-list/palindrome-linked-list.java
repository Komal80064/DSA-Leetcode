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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = null;

        // find middle of LL
        while(fast != null && fast.next != null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevSlow.next = null;

        // Reverse of half LL(Using middle)
        ListNode prev = null;
        while(slow != null){ 
            ListNode next = slow.next;  // store next node
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        while(head != null){
            if(head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}