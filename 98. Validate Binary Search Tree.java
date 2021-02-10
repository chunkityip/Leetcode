//DFS by recursion
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    /*
     * The Binary Search Tree role is : 1. The left node should smaller than head
     * node and parents node 2. The right node should bigger than head node and
     * parents node
     */

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null)
            return true;
        int val = root.val;
        // if we have lower number and head node vale is smaller or equal to lower
        // ,return false because of role 1
        if (lower != null && val <= lower)
            return false;
        // if we have upper number and head node vale is bigger or equal to upper
        // ,return false because of role 2
        if (upper != null && val >= upper)
            return false;

        /*
         * Not only the right child should be larger than the node but all the elements
         * in the right subtree (parents node) Not only the left child should be smaller
         * than the node but all the elements in the left subtree (parents node) Both
         * upper and lower limits for each node while traversing the tree, and compare
         * the node value not with children values but with these limits
         */

        // reucrsion the upper and root.right
        if (!helper(root.right, val, upper))
            return false;
        // reucrsion the lower and root.left
        if (!helper(root.left, lower, val))
            return false;
        return true;
    }
}

// or
class Solution {
    public boolean isValidBST(TreeNode root) {
        // because 0 node is still balance , so it is BST
        if (root == null)
            return true;
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer max, Integer min) {
        // same as previous node
        if (root == null)
            return true;

        // becaseu BST principle are : left always smaller than root and right always
        // bigger than root
        // if max and min no longer null and they both are not match the BST principle ,
        // they are not BST ,return false
        if ((max != null && root.val >= max) || (min != null && root.val <= min))
            return false;

        boolean left = helper(root.left, root.val, min);
        boolean right = helper(root.right, max, root.val);

        return left && right;
    }
}

// DFS by stack
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double left_chi_val = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= left_chi_val)
                return false;
            left_chi_val = root.val;
            root = root.right;
        }
        return true;
    }
}