public class SecondLargestItemInBst {

    public static int findSecondLargest(BinaryTreeNode root) {
        if (root == null || (root.left == null
                && root.right == null)) {
            throw new IllegalArgumentException();
        }

        BinaryTreeNode node = root;

        while(true) {
            if (node.right == null && node.left != null) {
                return findLargest(node.left);
            }
            if (node.right != null && node.right.left == null && node.right.right == null) {
                return node.value;
            }
            node = node.right;
        }
    }

    private static int findLargest(BinaryTreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
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