// Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
//The first node is considered odd, and the second node is even, and so on.
//Note that the relative order inside both the even and odd groups should remain as it was in the input.
// Input: 1 -> 2 -> 3 -> 4 -> 5
// Output: 1 -> 3 -> 5 -> 2 -> 4

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        
        return head;
    }
}

// Modified Question
/* If order of odd and even is not alternative i.e odd and even numbers are given in random order in Question
   Output - even numbers should appear before all the odd numbers in the modified list
   Input: 17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL
   Output: 8 -> 2 -> 4 -> 6 -> 17 -> 15 -> 9
*/
class Solution{
    Node evenOddList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node even = new Node(-1);
        Node odd = new Node(-1);
        Node evenHead = even;
        Node oddHead = odd;
        
        while(head != null){
            if(head.data%2 == 0){
                even.next = head;
                even = even.next;
            }else{
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
        }
        odd.next = null;
        even.next = oddHead.next;
        return evenHead.next;
    }
}
