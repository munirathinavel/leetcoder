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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root, res, new HashMap<>());
        return res;
    }
    
    private String dfs(TreeNode root, List<TreeNode> res, HashMap<String, Boolean> map) {
        if(root == null) {
            return "null";
        }
        String left = dfs(root.left, res, map);
        String right = dfs(root.right, res, map);
        String key = root.val + "#" + left + "#" + right;
        if(map.containsKey(key)) {
            if(!map.get(key)) {
                map.put(key, true);
                res.add(root);
            }
        } else {
            map.put(key, false);
        }
        return key;
    }
}