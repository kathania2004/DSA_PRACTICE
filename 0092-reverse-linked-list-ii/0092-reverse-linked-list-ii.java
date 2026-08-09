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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode t = head;
        ListNode before = null;

        int pos = 1;

        // Move t to the left position
        while (pos < left) {
            before = t;
            t = t.next;
            pos++;
        }

        // Reverse from left to right
        ListNode curr = t;
        ListNode prev = null;

        int times = right - left + 1;

        while (times-- > 0) {
            ListNode nex = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        // Connect reversed part to remaining list
        t.next = curr;

        // Connect part before left to reversed part
        if (before != null) {
            before.next = prev;
            return head;
        } else {
            // left == 1
            return prev;
        }
    }
}