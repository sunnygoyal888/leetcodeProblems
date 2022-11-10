## Basics

### Reverse a Linked List
**Iterative**
<p align="center">
<img height="300" src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/RGIF2.gif">
</p>

```java
class Solution {
    public ListNode reverseList(ListNode head) {
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
}
```

**Recursive**

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)   return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
```

___

### Linked List Cycle

**Floyds' Cycle Detection Algorithm**
```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;      // node where cycle begins
            }
        }
        return null;      // no cycle present
    }
}
```

___

### Remove Nth Node From End of List

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        
        if(fast == null){
            return head.next;
        }
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}
```
