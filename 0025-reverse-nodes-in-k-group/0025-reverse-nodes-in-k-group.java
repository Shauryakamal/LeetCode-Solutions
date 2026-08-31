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
    public ListNode reverseKGroup(ListNode head, int k) {
         ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;
        while (true) {
            ListNode check = current;
            for (int i = 0; i < k; i++) {
                check = check.next;
                if (check == null) {
                    return dummy.next;
                }
            }
            ListNode first = current.next;
            ListNode previous = check.next;
            ListNode node = first;

            for (int i = 0; i < k; i++) {
                ListNode next = node.next;
                node.next = previous;
                previous = node;
                node = next;
            }
            current.next = previous;

            current = first;
        }
    }
}