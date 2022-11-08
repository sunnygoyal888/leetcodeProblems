// Question link - https://leetcode.com/problems/reverse-nodes-in-k-group/
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while(pointer != null){
            ListNode node = pointer;
            // first check whether there are k nodes to reverse
            for (int i = 0; i < k && node != null; i++) {
                node = node.next;
            }
            if (node == null) break;
            
            ListNode prev = null, curr = pointer.next, next = null;
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode tail = pointer.next;
            tail.next = curr;
            pointer.next = prev;
            pointer = tail;
        }
        return dummy.next;
    }
}

/*
Explanation - 
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
Add dummy node
0 (pointer) -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7

Reverse k nodes -
step1: 0 (pointer) -> 1      2 -> 3 -> 4 -> 5 -> 6 -> 7
step2: 0 (pointer) -> 1 <- 2      3 -> 4 -> 5 -> 6 -> 7
step3: 0 (pointer) -> 1 <- 2 <- 3      4 -> 5 -> 6 -> 7

step3: 0 (pointer) -> 1 <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7

Adjusting the node links -
after 1st line:   0 (pointer) -> 1 (tail) <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
after 2nd line:   0 (pointer) -> 1 (tail) <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
				 |____________________________↑
after 3rd line:   
		      |---------------------------↓
		  0 (pointer)    1 (tail) <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
			         |____________________________↑

after 4th line:	  0 -> 3 -> 2 -> 1 (pointer) -> 4 -> 5 -> 6 -> 7

*/
