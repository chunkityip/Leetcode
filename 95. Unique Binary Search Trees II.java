class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        // if the left biggern than right, it means no more left node , put null into
        // left
        if (start > end) {
            list.add(null);
            return list;
        }

        // i is representing root
        for (int i = start; i <= end; i++) {
            /*
             * becuase of BST, left is smaller than root , so left is range between 1 to
             * root - 1 right is bigger than root , so right is range between root + 1 to n
             */
            List<TreeNode> leftNodes = helper(start, i - 1);
            List<TreeNode> rightNodes = helper(i + 1, end);

            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}