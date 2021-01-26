class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //create a ListNode call dummy 
        ListNode dummy = new ListNode (0); 
        //create a ListNode call l3, l3 = dummy which is 0 
        ListNode l3 = dummy;
        // while l1 and l2 is not empty
        while (l1 !=null && l2!= null) {  
            //if l1 value small or equal to l2 value
            if (l1.val <= l2.val){   
                //l3 next will be l1               
                l3.next = l1;
                // l1 euqal l1 next 
                l1 = l1.next;
            } else {
                //l3 next will be l2
                l3.next = l2;
                // l2 euqal l2 next 
                l2 = l2.next;
                }
            // l3 equal l3 next
            l3 = l3.next;


        }
        /* if (l1!=null) {
            l3.next = l1;
        }
        if (l2!=null) {
            l3.next = l2;  
        }
        */
        l3.next = l1 == null ? l2 : l1;
    
        return dummy.next;
    }
}

/*It basically said if l1 value <= l2 value
l3 next will be the l1 value and then the pointer l1 will shift to l1 next so we can keep compare the next round

else , l3 next will be the l2 value and then the pointer l2 will shift to l2 next so we can keep compare the next round

after the while loop finish. It will have at least one linkedList still have something which is the biggest one 
just connect to l3 next
*/



//or 

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 ==null) return l2;
        if (l2 ==null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next , l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1 , l2.next);
            return l2;
        }
    }
}

