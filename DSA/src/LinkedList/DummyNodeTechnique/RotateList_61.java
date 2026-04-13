package LinkedList.DummyNodeTechnique;

import LinkedList.ListNode;

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: find length
        ListNode temp = head;
        int length = 1;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Step 2: make circular
        temp.next = head;

        // Step 3: normalize k
        k = k % length;

        // Step 4: find new tail
        int steps = length - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Step 5: new head
        ListNode newHead = newTail.next;

        // Step 6: break cycle
        newTail.next = null;

        return newHead;
    }
}
