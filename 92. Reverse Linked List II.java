//92. Reverse Linked List II 

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        // looking for the starting position
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }
        // now prev is 1 and curr is 2
        ListNode curr = prev.next;

        /*
         * first loop 1 -> 3 -> 2 -> 4 -> 5 ^ ^ ^ ^ prev next curr next.next Second loop
         * 1 -> 4 - > 3 -> 2 -> 5 ^ ^ ^ ^ ^ prev next prev.next curr next.next 1 -> 4 ->
         * 3 -> 2 -> 5
         */
        for (int i = m; i < n; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
}
