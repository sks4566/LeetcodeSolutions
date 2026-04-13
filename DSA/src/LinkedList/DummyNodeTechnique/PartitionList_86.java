package LinkedList.DummyNodeTechnique;

import LinkedList.ListNode;

public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;
                less = less.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }

        // IMPORTANT: terminate greater list
        greater.next = null;

        // connect both lists
        less.next = greaterDummy.next;

        return lessDummy.next;
    }
}
