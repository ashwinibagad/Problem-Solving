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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        
        if(head.next==null){
            return null;
        }
        
        ListNode currentNode=head;
        while(currentNode!=null){
            currentNode=currentNode.next;
            size++;
        }
        
        if(n==size){
            return head.next;
        }
        
        int previousPosition=size-n;
        
        ListNode previousNode=head;
        for(int i=1;i<previousPosition;i++){
            previousNode=previousNode.next;
        }
        
        previousNode.next=previousNode.next.next;
        
        return head;
    }
}
