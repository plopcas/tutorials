public class LinkedListCycles {
    // O(n) time and O(n) space
    public boolean containsCycle(LinkedListNode node) {
        Set<LinkedListNode> nodes = new HashSet<>();
        while (node != null) {
            if (nodes.contains(node)) {
                return true;
            }
            nodes.add(node);
            node = node.next;
        }
        return false;
    }

    // O(n) time and O(1) space
    public boolean containsCycleOptimised(LinkedListNode node) {
        LinkedListNode slowRunner = node;
        LinkedListNode fastRunner = node;

        while (fastRunner != null && fastRunner.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
            if (fastRunner == slowRunner) {
                return true;
            }
        }
        return false;
    }
}

public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}