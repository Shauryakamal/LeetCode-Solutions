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
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;
        ListNode current = head;
        while(current != null){
            if(current.val < x){
            small.next = current;
            small = small.next;    
        }else{
            large.next = current;
            large = large.next;
        }
        current = current.next;
    }
    large.next = null;
    small.next = largeDummy.next;
    return smallDummy.next;
}
}