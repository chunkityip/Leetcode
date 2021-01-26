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
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        // the reson of len to count the length of ListNode
        int len = 0;
        while (fast != null) {
            //this step will count for it 
            len++;
            fast = fast.next;
        }
        fast = head;
        for (int i = 0; i < k % len; i++) {
            // Once we check 3 % 3 is 0 which mean I get the number we want to putting to head
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // putting the number we want to head
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}

// or 

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        // cuase the adove while loop , curr.next will be the last node , just simply
        // putting curr.next to head
        // 1 -> 2 -> 3 -> 4 -> (5)<curr.next ---> 5 -> 1 -> 2
        curr.next = head;

        for (int i = 1; i < length - k % length; i++) {
            head = head.next;
        }

        // after above loop , we get the last k number to head. Therefore , cutting last
        // k number in the original list
        // 4->5->1->2->(3)<-head-X-> 4 -> 5 4->5->1->2->3
        ListNode ans = head.next;
        head.next = null;
        return ans;
    }
}