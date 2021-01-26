//* Solution 1 : Two Pointer by running LinkedList two time
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        // here need to do 1 more
        dummy.next = head;
        ListNode curr = head;
        int length = 0;
        // first time
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        length -= n;
        // everything time connect to dummy need to recall it again
        curr = dummy;
        // second time
        while (length > 0) {
            length--;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;

    }
}

/*
 * Time complexity: O(L). This algorith run two time to slove the problem. First
 * to count the list length L and second to find the (L-N)node WHICH IS 2L- N
 * operations which mean O(L)
 * 
 * Space complexity: O(1). We only constant extra space
 */

// * Solution 2 : Using Two Pointer by running one time only
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        // because the array index start from 0.To able to match the nagtivie position ,
        // fast need to go forward first
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // moving slow pointer forward and fast pointer forward + 1. fast pointer will
        // fast 2 postition compare to slow pointer
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
/*
 * Time complexity: O(L). This algorith one two time to slove the problem by
 * finding the (L)node WHICH IS O(L).
 * 
 * Space complexity: O(1). We only constant extra space
 */