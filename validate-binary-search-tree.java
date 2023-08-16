// Problem is the same with tree inorder traversal 
// difference: track order. 
// approach: have a node that keeps the previous node in order to check that the value is in the right order from min to max. 
// why not have an integer? because some maniac decided to have the last 7 test cases to check for only overflow values HAHAHAHA
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        Stack <TreeNode> stack = new Stack<>();

        TreeNode minVal = null;

        while (root != null || !stack.empty())
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print (root.val + " ");
            if (minVal != null && minVal.val >= root.val) return false;
            minVal = root;
            root = root.right;
            
        }

        return true;
    }
}