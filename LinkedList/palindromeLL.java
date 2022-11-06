// Approach - Using slow & fast pointer | Find Middle node | Reverse right half & compare || TC - O(n) || SC - O(1)
class Solution {
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        // find middle of linked list
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse right half
        ListNode prev = null;
        ListNode curr = slow.next;
        while(curr != null){
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        
        slow.next = prev;
        slow = slow.next;
        // check for palindrome
        while(slow != null){
            if(head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        
        return true;
    }
}

/* Approach - Using Arraylist || TC - O(n) || SC - O(n)
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        for(int i = 0; i < list.size()/2; i++){
            if(list.get(i) != list.get(list.size()-i-1)){
                return false;
            }
        }
        return true;
    }
*/

/*  Approach - Recursive || TC - O(n) || SC - O(n)
class Solution {
    public ListNode start;
    public boolean isPalindrome(ListNode head) {
        start = head;
        return isPalindromeHelper(head);
    }
    
    public boolean isPalindromeHelper(ListNode head){
        if(head == null){
            return true;
        }
        boolean b = isPalindromeHelper(head.next);
        if(start.val == head.val){
            start = start.next;
        }else{
            return false;
        }
        
        return b;
    }
}
*/
