/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// DFS
class Solution {
    
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            dfs(root, 1, res);
        }
        return res;
    }
    
    private void dfs(Node root, int depth, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        if(res.size() < depth) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(root.val);
            res.add(row);
        } else {
            res.get(depth-1).add(root.val);
        }
        for(Node next:root.children) {
            dfs(next, depth+1, res);
        }
    }
}
// BFS with Queue
// class Solution {
//     public List<List<Integer>> levelOrder(Node root) {
//         List<List<Integer>> res = new ArrayList<>();
//         if(root == null) {
//             return res;
//         }
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
        
//         while(!q.isEmpty()) {
//             int size = q.size();
//             List<Integer> levelList = new ArrayList<>();
//             for(int i = 0; i < size; i++) {
//                 Node current = q.poll();
//                 levelList.add(current.val);
//                 for(Node adj: current.children) {
//                     q.add(adj);
//                 }
//             }
//             res.add(levelList);
//         }
//         return res;
//     }
// }