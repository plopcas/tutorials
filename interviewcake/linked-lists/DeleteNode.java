public class DeleteNode {
    public void deleteNode(LinkedListNode node) {
        if (node == null) {
            throw new RuntimeException("Can't delete a null node");
        } else if (node.next == null) {
            throw new RuntimeException("Can't delete the last node");
        }
        node.value = node.next.value;
        node.next = node.next.next;
    }
}

public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}
