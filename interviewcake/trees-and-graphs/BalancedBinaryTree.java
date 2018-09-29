public class BalancedBinaryTree {
    // superbalanced is a made up property that means the difference
    // between the depths of any two leaf nodes is no greater than one
    public boolean isSuperbalanced(BinaryTreeNode rootNode) {

        if (rootNode == null) {
            throw new IllegalArgumentException();
        }
        if (rootNode.left == null && rootNode.right == null) {
            return true;
        }

        List<Integer> depths = new ArrayList<>();

        Deque<NodeDepthPair> stack = new ArrayDeque<>();
        stack.push(new NodeDepthPair(rootNode, 0));

        while (!stack.isEmpty()) {

            NodeDepthPair ndp = stack.pop();
            BinaryTreeNode node = ndp.node;
            int depth = ndp.depth;

            // if it's a leaf
            if (node.left == null & node.right == null) {
                // check depth
                if (!depths.contains(depth)) {
                    depths.add(depth);
                    if (depths.size() > 2) {
                        return false;
                    } else if (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1) {
                        return false;
                    }
                }
            } else {
                if (node.left != null) {
                    stack.push(new NodeDepthPair(node.left, depth + 1));
                }
                if (node.right != null) {
                    stack.push(new NodeDepthPair(node.right, depth + 1));
                }
            }
        }

        return true;
    }
}

public class NodeDepthPair {
    public BinaryTreeNode node;
    public int depth;

    public NodeDepthPair(BinaryTreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
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