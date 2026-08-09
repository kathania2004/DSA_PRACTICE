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

        if(head == null || head.next == null){
            return head;
        }

        ListNode left = head;
        ListNode right = head.next;
        ListNode prevleft = null;
        ListNode res = right;
        while(left != null && right != null){
            ListNode nextleft = right.next;
            right.next = left;
            left.next = nextleft;

            if(prevleft != null){
                prevleft.next = right;
            }

            prevleft = left;
            left = nextleft;

            if(left != null){
                right = left.next;
            }
        }
        return res;
    }
}