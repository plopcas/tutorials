public class LargestStack {

    public static class MaxStack {

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> maxValues = new ArrayDeque<>();

        public void push(int item) {
            if (maxValues.isEmpty() || item >= maxValues.peek()) {
                maxValues.push(item);
            }
            stack.push(item);
        }

        public int pop() {
            int item = stack.pop();
            if (item == maxValues.peek()) {
                maxValues.pop();
            }
            return item;
        }

        public int getMax() {
            return maxValues.peek();
        }
    }

}