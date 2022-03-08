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
    
    public ListNode getMiddleNode(ListNode head){
        ListNode hare=head;
        ListNode turtle=head;

        while(hare.next!=null && hare.next.next!=null){
            hare=hare.next.next;
            turtle=turtle.next;
        }

        return turtle;
    }

    public ListNode reverse(ListNode head){

        ListNode previous=head;
        ListNode current=head.next;

        while(current!=null){
            ListNode next=current.next;

            current.next=previous;
            previous=current;
            current=next;
        }

        head.next=null;
        head=previous;

        return head;
    }

    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null){
            return true;
        }

        ListNode middle = getMiddleNode(head);
        ListNode secondHalf = reverse(middle.next);
        ListNode firstHalf=head;

        while(secondHalf!=null){
            if(secondHalf.val!=firstHalf.val){
                return false;
            }
            secondHalf=secondHalf.next;
            firstHalf=firstHalf.next;
        }
        return true;
    }
}
