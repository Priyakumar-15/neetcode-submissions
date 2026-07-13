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
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr= head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
         return slow;
    }
    public void reorderList(ListNode head) {
        if(head == null) return;
       ListNode middle = findMiddle(head);
       ListNode head2=reverseList(middle.next);
       middle.next=null;
       while(head != null && head2 != null){
             ListNode next1= head.next;
             ListNode next2= head2.next;
             head.next=head2;
             head2.next=next1;
             head=next1;
             head2=next2;
       }
       

    }
}
