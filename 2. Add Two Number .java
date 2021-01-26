/* Add Two Number

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

We can create a integer call carry , when l1 + 12 % 10 == 1 , store 1 into carry , and then add carry + l1.next  + carry + 12.next

First, set the dummy ListNode and set up a new ListNode call curr. (Remeber, Every LinkedList question need to open a dummy node)
Second, set a ListNode to store l1 , name as p
        set a ListNode to store l2 , name as q
Third , create a new integer call carry to store the value 1 

using while loop to start the loop , 
create a integer call x to ask is p is null or not ? if p isn't null , point to p.val , else display 0
create a integer call y to ask is q is null or not ? if q isn't null , point to q.val , else display
now we can sum the value we want by creating a new integer call sum : sum will add carry , x and y
now we can do sum / 10 and store it to carry , if the sum equal to 10 , 10 / 10 = 1. Carry will have value 1. 
Therefore, when the loop start over again , sum = carry which is 1 + x + y 
create a new ListNode call curr.next and the value is sum % 10. MeanWhile, switch curr to curr.next.
********
curr = 
curr.next = 7 % 10 = 7
when curr = curr.next , which mean the value curr.next as 7 will equal to curr value 

After switching, 

curr = 7 
curr.next = 10 % 10 = 0

After switching, 

curr = 7 -> 0 
curr.next = 1(carry) + 3 + 4 % 10 = 8

curr = 7 -> 0 -> 8
********

now we need to switch the point p to p.next by just asking if p is empty or not
same as p , asking if q is empty or not. If a isn't empty , q = q.next

checking if carry is equal to 1, adding ListNode 1 into the end of ListNode
returning the dummy next which is the beginning of the ListNode.

********
Without the dummy head , we would have to write extra condition statements to initizlize the heads value.
Because this is singly linked list , it can't backword to the first node but the method need to return the first node when the method finish
By creating a dummyhead , point the first ListNode to dummyhead. When we need to return the first node , we cant simply return dummy head.next
*******

*/

class Main {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        int p = l1 , q = l2 , curr = dummyhead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int j = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.node = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyhead.next;
}

/* Time complexity  : O (max(m,n)). Assume the m represent l1 , n represent l2. It is possiable that one ListNode is longer than others.
Therefore, O (max(m,n)) to see which is bigger time complexity.

if both m and n are same , it will display the same result.
if not, it will display the max result.

Space Complexiy :  O (max(m,n)). Becuase we are creating a new ListNode call curr and the length of curr will see l1 length and 12 length.
Therefore, The length of the new list is at most max(m,n) + 1. (Remeber , the dummy head is empty).


/* Follow Up
At the end of solution, it shows What if the the digits in the linked list are stored in non-reversed order? For example:
(3→4→2)+(4→6→5)=8→0→7

My though was same as this bro too, count backworded and backword the answer.
Bacially is swap.
https://leetcode.wang/leetCode-2-Add-Two-Numbers.html

(3→4→2) change to (2→4→3)
(4→6→5) change to (5→6→4)
(2→4→3) + (5→6→4) = (7→0→8)
Finally , (7→0→8) change to (8→0→7)

*/

public ListNode reverseList (ListNode head) {
    if (head == null) return null;
    ListNode pre = null;
    ListNode next;

    while (head != null) {
        next = head.next;
        head.next = pre;
        pre = head;
        head = next;
    }
    return pre;
}


