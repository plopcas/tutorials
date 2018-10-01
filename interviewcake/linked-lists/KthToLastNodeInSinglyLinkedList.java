public class KthToLastNodeInSinglyLinkedList {

    // O(n) time and O(k) space, but we traverse the list only once
    public static LinkedListNode kthToLastNode(int k, LinkedListNode node) {

        if (k < 1) {
            throw new IllegalArgumentException("k must be at least 1");
        }

        Deque<LinkedListNode> queue = new ArrayDeque<>();
        int listSize = 0;

        while (node != null) {
            if (queue.size() >= k) {
                queue.remove();
            }
            queue.add(node);
            listSize++;
            node = node.next;
        }

        if (k > listSize) {
            throw new IllegalArgumentException("k can't be larger than the list");
        }

        return queue.peekFirst();
    }

    // keeping pointers instead of a queue, we can reduce the space complexity
    // but we have to traverse the list twice so it will be slower

    // O(n) time and O(1) space but we traverse the list twice, once per pointer
    public static LinkedListNode kthToLastNode1(int k, LinkedListNode head) {

        if (k < 1) {
            throw new IllegalArgumentException(
                    "Impossible to find less than first to last node: " + k);
        }

        LinkedListNode leftNode = head;
        LinkedListNode rightNode = head;

        for (int i = 0; i < k - 1; i++) {

            if (rightNode.next == null) {
                throw new IllegalArgumentException(
                        "k is larger than the length of the linked list: " + k);
            }

            rightNode = rightNode.next;
        }

        while (rightNode.next != null) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        return leftNode;
    }

    // it's the same when we traverse the list twice to get the size first and then
    // only up to the required node at length - k
    public static LinkedListNode kthToLastNode2(int k, LinkedListNode head) {

        if (k < 1) {
            throw new IllegalArgumentException("Impossible to find less than first to last node: " + k);
        }

        int listLength = 1;
        LinkedListNode currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            listLength += 1;
        }

        if (k > listLength) {
            throw new IllegalArgumentException("k is larger than the length of the linked list: " + k);
        }

        int howFarToGo = listLength - k;

        currentNode = head;
        for (int i = 0; i < howFarToGo; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

}

public class LinkedListNode {

    public String value;
    public LinkedListNode next;

    public LinkedListNode(String value) {
        this.value = value;
    }
}