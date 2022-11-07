class Solution {
  // Approach - Using Merge sort
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)   return head;
        
        ListNode slow = head, fast = head, prev = null;
      // Cut the list into two halves
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
      // Sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
      // Merge sorted lists
        return mergeSortedList(l1, l2);
    }
    
    public ListNode mergeSortedList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null){
            temp.next = l1;
        }
        if(l2 != null){
            temp.next = l2;
        }
        return dummy.next;
    }
}

/* Approach - Using ArrayList
public ListNode sortList(ListNode head) {
    if(head == null)    return head;
    ArrayList<Integer> list = new ArrayList<>();
    ListNode temp = head;
    while(temp != null){
        list.add(temp.val);
        temp = temp.next;
    }
    Collections.sort(list);
    ListNode newHead = new ListNode(list.get(0));
    temp = newHead;
    for(int i = 1; i < list.size(); i++){
        ListNode node = new ListNode(list.get(i));
        temp.next = node;
        temp = temp.next;
    }
    return newHead;
}
*/


// Modified Question
// GFG Question link - https://practice.geeksforgeeks.org/problems/linked-list-that-is-sorted-alternatingly/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=linked-list-that-is-sorted-alternatingly
// Given a Linked list of size N, the list is in alternating ascending and descending orders. Sort the given linked list in non-decreasing order.
// Input: 1->9->2->8->3->7->5->4
// Output: 1->2->3->4->5->7->8->9
/* Intuition -
  1) Separate or cut the list into two separate ascending and descending sorted lists.
  2) Reverse right or descending order list.
  3) Merge both the lists.
*/

class Solution {
   public Node sort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node asc = head;
        Node desc = head.next;
        Node descHead = head.next;
        while(desc != null && desc.next != null){   // separate list
            asc.next = asc.next.next;
            asc = asc.next;
            desc.next = desc.next.next;
            desc = desc.next;
        }
        asc.next = null;
        // Reverse the desc list
        Node prev = null, curr = descHead;
        while(curr != null){
            Node Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        descHead = prev;
        // Merge both lists
        return merge(head, descHead);
   }
   
   public Node merge(Node l1, Node l2){
       Node dummy = new Node(-1);
       Node temp = dummy;
       while(l1 != null && l2 != null){
           if(l1.data <= l2.data){
               temp.next = l1;
               l1 = l1.next;
           }else{
               temp.next = l2;
               l2 = l2.next;
           }
           temp = temp.next;
       }
       if(l1 != null){
           temp.next = l1;
       }
       if(l2 != null){
           temp.next = l2;
       }
       return dummy.next;
   }

}

