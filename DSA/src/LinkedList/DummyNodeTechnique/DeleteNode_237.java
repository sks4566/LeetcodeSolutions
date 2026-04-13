package LinkedList.DummyNodeTechnique;

import LinkedList.ListNode;

public class DeleteNode_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
