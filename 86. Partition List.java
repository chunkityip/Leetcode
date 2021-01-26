class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode smallCurr = dummy1;
        ListNode bigCurr = dummy2;

        while (head != null) {
            ListNode value = new ListNode(head.val);
            if (head.val < x) {
                smallCurr.next = value;
                smallCurr = smallCurr.next;
            } else {
                bigCurr.next = value;
                bigCurr = bigCurr.next;
            }
            head = head.next;
        }
        smallCurr.next = dummy2.next;
        return dummy1.next;
    }
}