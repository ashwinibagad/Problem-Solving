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
    public ListNode swapPairs(ListNode head) {
        ListNode currentNode=head;
        while(currentNode!=null && currentNode.next!=null){
            int temp=currentNode.val;
            currentNode.val=currentNode.next.val;
            currentNode.next.val=temp;
            currentNode=currentNode.next.next;
        }
        return head;
    }
}
