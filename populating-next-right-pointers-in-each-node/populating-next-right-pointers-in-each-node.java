/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// BFS 
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node current = q.poll();
               if(i == size-1) {
                   current.next = null;
               }  else {
                   current.next = q.peek();
               }
                if(current.left != null) {
                    q.add(current.left);
                }
                
                if(current.right != null) {
                    q.add(current.right);
                }
            }
        }
        return root;
    }
}
// Tree Solution
// public class Solution {
//     public Node connect(Node root) {
//         Node levelStart = root;
//         while(levelStart!=null){
//             Node cur=levelStart;
//             while(cur!=null){
//                 if(cur.left!=null) cur.left.next=cur.right;
//                 if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                
//                 cur=cur.next;
//             }
//             levelStart=levelStart.left;
//         }
//         return root;
//     }
// }