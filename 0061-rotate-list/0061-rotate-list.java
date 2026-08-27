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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k ==0){
            return head;
        }
        int length = 0;
        ListNode current = head;

        while(current != null){
            length++;
            current = current.next;
        }
        k = k % length;
        while(k == 0){
            return head;
        }
        current = head;

        while(current.next != null){
            current = current.next;
        }
        current.next = head;    
        int steps = length -k;

        ListNode newTail = head;

        for(int i =1; i<steps; i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;
    }
}