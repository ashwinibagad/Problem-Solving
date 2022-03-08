/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode currentNode = node;
        ListNode nextNode = currentNode.next;
        currentNode.val = nextNode.val;
        currentNode.next = nextNode.next;
    }
}
