// Question link - https://leetcode.com/problems/add-two-numbers-ii/

// Steps - 
// 1) Reverse both input LLs
// 2) Add both LLs
// 3) Reverse the output LL

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode result = add(l1, l2);
        result = reverse(result);
        return result;
    }
    
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null)   return head;
        ListNode prev = null;
        while(head != null){
            ListNode Next = head.next;
            head.next = prev;
            prev = head;
            head = Next;
        }
        return prev;
    }
    
    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            carry = sum / 10;
            if(l1 != null)  l1 = l1.next;
            if(l2 != null)  l2 = l2.next;
        }
        return dummy.next;
    }
}
