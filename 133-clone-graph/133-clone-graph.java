/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
// DFS - Recursive
class Solution {
    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        if(visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clonedNode = new Node(node.val, new ArrayList());
        visited.put(node, clonedNode);
        
        for(Node neighbor:node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return clonedNode;
    }
}

// BFS - Iterative
// class Solution {
//     public Node cloneGraph(Node node) {
//         if(node == null) {
//             return node;
//         }
//         HashMap<Node, Node> visited = new HashMap();
//         LinkedList<Node> q = new LinkedList<Node>();
//         q.add(node);
//         visited.put(node, new Node(node.val, new ArrayList()));
        
//         while(!q.isEmpty()) {
//             Node current = q.remove();
            
//             for(Node neighbor: current.neighbors) {
//                 if(!visited.containsKey(neighbor)) {
//                     visited.put(neighbor,new Node(neighbor.val, new ArrayList<>()));
//                     q.add(neighbor);
//                 }
//                 visited.get(current).neighbors.add(visited.get(neighbor));
//             }
//         }
//         return visited.get(node);
//     }
// }