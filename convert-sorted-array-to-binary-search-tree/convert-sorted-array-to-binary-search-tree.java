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
    int[] nums;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length-1);
    }
    
    private TreeNode helper(int l, int r){
        if(l > r) return null;
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(l, m-1);
        root.right = helper(m+1, r);
        return root;
    }
}