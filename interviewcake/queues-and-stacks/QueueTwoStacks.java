public class QueueTwoStacks {
    private Deque<Integer> inStack = new ArrayDeque<>();
    private Deque<Integer> outStack = new ArrayDeque<>();

    public void enqueue(int item) {
        inStack.push(item);
    }

    // O(m^2)
    public int dequeue() {
        int item;
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        item = outStack.pop();
        // move everything back to inStack
        while (!outStack.isEmpty()) {
            inStack.push(outStack.pop());
        }
        return item;
    }
}

public class QueueTwoStacksOptimised {
    private Deque<Integer> inStack = new ArrayDeque<>();
    private Deque<Integer> outStack = new ArrayDeque<>();

    public void enqueue(int item) {
        inStack.push(item);
    }

    public int dequeue() {
        // only move items to outStack when it's empty
        // otherwise we still have items to dequeue
        // this is more efficient
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }

            // at this point we should have elements, if not, the whole queue is empty and there is nothing to return
            if (outStack.isEmpty()) {
                throw new RuntimeException("No items to dequeue");
            }
        }

        return outStack.pop();
    }
}