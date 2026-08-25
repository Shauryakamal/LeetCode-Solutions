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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        ListNode a = l1;
        ListNode b = l2;
        int carry = 0;
        while(a != null || b != null){
            int sum = carry;

            if(a != null){
                sum += a.val;
                a = a.next;
            }
            if(b != null){
                sum += b.val;
                b = b.next;
            }
            carry = sum / 10;
            int digit = sum % 10;

            current.next = new ListNode(digit);
            current = current.next;
        }
        if(carry > 0){
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}