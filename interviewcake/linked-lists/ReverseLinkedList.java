public class ReverseLinkedList {
    public LinkedListNode reverse(LinkedListNode node) {

        if (node == null || node.next == null) {
            return node;
        }

        List<LinkedListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        for (int i = list.size() - 1; i >= 1; i--) {
            LinkedListNode currentNode = list.get(i);
            currentNode.next = list.get(i - 1);
        }

        LinkedListNode newTail = list.get(0);
        newTail.next = null;

        return list.get(list.size() - 1);
    }

    public LinkedListNode reverseBetter(LinkedListNode node) {

        if (node == null || node.next == null) {
            return node;
        }

        LinkedListNode previousNode = node;
        LinkedListNode currentNode = node.next;
        node.next = null;
        while (currentNode != null) {
            LinkedListNode tmp = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = tmp;
        }

        return previousNode;
    }

    public LinkedListNode reverseSameButABitClearer(LinkedListNode node) {

        LinkedListNode previousNode = null;
        LinkedListNode currentNode = node;
        LinkedListNode nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }

    public LinkedListNode reverseOutOfPlace(LinkedListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        LinkedListNode previousNode = new LinkedListNode(node.value);
        previousNode.next = null;

        while (node.next != null) {
            node = node.next;
            LinkedListNode currentNode = new LinkedListNode(node.value);
            currentNode.next = previousNode;
            previousNode = currentNode;
        }

        return currentNode;
    }
}

public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}