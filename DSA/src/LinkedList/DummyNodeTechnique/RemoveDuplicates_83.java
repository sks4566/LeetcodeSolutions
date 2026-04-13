package LinkedList.DummyNodeTechnique;

import LinkedList.ListNode;

public class RemoveDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // skip duplicate
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
