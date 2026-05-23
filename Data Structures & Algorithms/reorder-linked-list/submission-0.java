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
    public ListNode findmid(ListNode head){
        ListNode slow=head;
        ListNode fast = head;
        while(fast !=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public  ListNode reverse(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp != null){
            ListNode next= temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode l1=head;
        ListNode mid=findmid(head);
        ListNode l2=reverse(mid.next);
        mid.next=null;
        
        
        while( l2 !=null){
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;

            l1.next = l2;
            l2.next = next1;

            l1 = next1;
            l2 = next2;

        }
        
            }
}
