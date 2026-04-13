package LinkedList.FastAndSlowPointer;

import LinkedList.ListNode;

import java.util.List;

public class MiddleOfLinkedList_876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.next == null ? slow : slow.next;
    }
}
