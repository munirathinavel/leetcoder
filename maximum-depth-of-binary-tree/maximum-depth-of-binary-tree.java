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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

// Top Down Approach
// class Solution {
//     int ans = 0;
//     public int maxDepth(TreeNode root) {
//         maxDepth(root, 1);
//         return ans;
//     }
//     private void maxDepth(TreeNode root, int depth) {
//         if(root == null) {
//             return ;
//         }
//         if(root.left == null && root.right == null) {
//             ans = Math.max(ans, depth);
//         }
//         maxDepth(root.left, depth + 1);
//         maxDepth(root.right, depth + 1);
//     }
// }