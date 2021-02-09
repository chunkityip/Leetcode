/* By using recursion , what we need to do is :
1. check if root.left != null , add root.left
2. add root.vol
3. check if root.right != null , add root.right
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    private void helper(TreeNode root , List<Integer> ans) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left , ans);
            }
        ans.add(root.val);
        
        if (root.right != null) {
            helper(root.right, ans);
            }
        }
    }
}

// Without using recursion , we can use strack to do it iteratively

/* For example :       1
                     /   \
                    2     3
                   / \
                  4   5
                   \
                    6
push all curr.left first which is 1 , 2 ,4
Because it is stack(last in first out) so ans will be 4 , 2 , 1
and then add the curr.value which is 6 so ans will be 4 ,2 , 1 ,6 
finally add all curr.right which is 3 and 5
because it is stack(last in first out) so ans will be 4 , 2 , 1 , 6 , 5 , 3
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                // first pushing all curr.left t= stack 
                stack.push(curr);
                curr = curr.left;
            }
            //pop all curr.left and then add curr.val in the middle
            curr = stack.pop();
            ans.add(curr.val);
            
            //then finally add all curr.right 
            curr = curr.right;
        }
        return ans;
    }
}
