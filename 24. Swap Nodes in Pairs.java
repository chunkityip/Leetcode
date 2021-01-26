/* 24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.
Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

Solution 1 : Recursion (Detail in why I can't do it)
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firsNode.next = swapPairs(secondNode.next);
        secondNode.next = firsNode;

        retrun secondNode;
    }

    // Solution 2 : Iterative Approach (Detail in why I can't do it)
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            while (head != null && head.next != null) {
                ListNode firstNode = head;
                ListNode secondNode = head.next;

                // curr->2
                curr.next = secondNode;
                // 1 -> 3 -> 4
                firsNode.next = secondNode.next;
                // curr->2->1->3->4
                secondNode.next = firsNode;

                /*
                 * 2-> 1 -> 3 -> 4 ^ curr
                 */
                curr = firsNode;
                /*
                 * 2-> 1 -> 3 -> 4 ^ ^ curr head;
                 */
                head = firstNode.next;

                /*
                 * go back to loop , ListNode firstNode as 3 = head ListNode secondNode as 4 =
                 * head.next;
                 * 
                 * curr.next = secondNode , so will be 2 -> 1 -> 4 firsNode.next =
                 * secondNode.next; secondNode.next = firsNode;
                 * 
                 * so will be 2 -> 1 -> 4 -> 3
                 */
            }
            return dummy.next;
        }
    }

    // or
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        dummy.next = head;
        
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            
            curr.next = second;
            first.next = second.next;
            second.next = first;
            
            curr = curr.next.next;
        }
        return dummy.next;
    }
}