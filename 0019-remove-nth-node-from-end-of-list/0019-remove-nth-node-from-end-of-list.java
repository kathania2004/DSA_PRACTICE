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
        if (head == null) {
            return head;
        }

        // Find length
        int k = 1;
        ListNode last = head;

        while (last.next != null) {
            k++;
            last = last.next;
        }

        // If removing the first node
        if (n == k) {
            return head.next;
        }

        // Reach the node before the one to delete
        int count = 1;
        ListNode req = head;

        while (count < k - n) {
            req = req.next;
            count++;
        }

        // Remove node
        req.next = req.next.next;

        return head;
    }
}