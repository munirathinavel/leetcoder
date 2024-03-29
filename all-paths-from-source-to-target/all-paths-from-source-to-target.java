
class Solution {
   
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList();
        if(graph == null || graph.length == 0) {
            return paths;
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList();
        path.add(0);
        queue.add(path);
        
        while(!queue.isEmpty()) {
            List<Integer> currentPath = queue.remove();
            int current = currentPath.get(currentPath.size() - 1);
            for(int next:graph[current]) {
                List<Integer> tempPath = new ArrayList(currentPath);
                tempPath.add(next);
                if(next == graph.length -1) {
                    paths.add(tempPath);
                } else {
                    queue.add(tempPath);
                }
            }
        }
        return paths;
    }
}

// Recursive Solution
// class Solution {
   
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         List<List<Integer>> paths = new ArrayList<>();
//         dfs(graph, 0, new ArrayList<>(), paths);
//         return paths;
//     }
    
//     private void dfs(int[][] graph, int node, ArrayList<Integer> path, List<List<Integer>> paths) {
//         path.add(node);
//         if(node == graph.length -1) {
//             paths.add(new ArrayList(path));
//             return;
//         }
//         for(int adj:graph[node]) {
//             dfs(graph, adj, path, paths);
//             path.remove(path.size() -1);
//         }
//     }
// }

//  Iterative Approach with Stack & Queue
// class Solution {
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         List<List<Integer>> res = new ArrayList<>();
//         Stack<Integer> s = new Stack<>();
//         s.push(0);
//         int dest = graph.length-1;
//         Deque<Integer> path  = new ArrayDeque<>();
        
//         while(!s.isEmpty()) {
//             Integer node = s.peek();
//             if(node == path.peekLast()) {
//                 path.removeLast();
//                 s.pop();
//                 continue;
//             }
//             path.add(node);
//             if(node == dest) {
//                 res.add(new ArrayList(path));
//                 path.removeLast();
//                 s.pop();
//                 continue;
//             }
//             for(int adj:graph[node]) {
//                 s.push(adj);
//             }
//         }
//         return res;
//     }
// }