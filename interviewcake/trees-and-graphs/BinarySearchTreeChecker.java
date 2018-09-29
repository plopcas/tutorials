public class BinarySearchTreeChecker {

    public boolean checkBST(BinaryTreeNode rootNode) {
        Deque<NodeBounds> stack = new ArrayDeque<>();
        stack.push(new NodeBounds(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while (!stack.isEmpty()) {
            NodeBounds nb = stack.pop();
            BinaryTreeNode node = nb.node;
            int lowerBound = nb.lowerBound;
            int upperBound = nb.upperBound;
            if (node.value > lowerBound && node.value < upperBound) {
                if (node.left != null) {
                    stack.push(new NodeBounds(node.left, lowerBound, node.value));
                }
                if (node.right != null) {
                    stack.push(new NodeBounds(node.right, node.value, upperBound));
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean checkBSTRecursive(BinaryTreeNode rootNode, int lowerBound, int upperBound) {
        // all the nodes in the branch have been checked
        if (rootNode == null) {
            return true;
        }

        if (node.value > lowerBound && node.value < upperBound) {
            return isBinarySearchTree(rootNode.left, lowerBound, rootNode.value)
                    && isBinarySearchTree(rootNode.right, rootNode.value, upperBound);
        } else {
            return false;
        }
    }

    private Integer previousValue;
    private boolean isBST = true;
    public boolean checkBSTInOrderTraversal(BinaryTreeNode node) {
        inOrderTraverse(node);
        return isBST;
    }

    public void inOrderTraverse(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.left);
        if (previousValue != null && node.value < previousValue) {
            isBST = false;
        } else {
            previousValue = node.value;
        }
        inOrderTraverse(node.right);
    }

    public class NodeBounds {
        public BinaryTreeNode node;
        public int lowerBound;
        public int upperBound;

        public NodeBounds(BinaryTreeNode node, int lowerBound, int upperBound) {
            this.node = node;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

    public class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }
}