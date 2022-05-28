class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int dest = graph.length-1;
        Deque<Integer> path  = new ArrayDeque<>();
        
        while(!s.isEmpty()) {
            Integer node = s.peek();
            if(node == path.peekLast()) {
                path.removeLast();
                s.pop();
                continue;
            }
            path.add(node);
            if(node == dest) {
                res.add(new ArrayList(path));
                path.removeLast();
                s.pop();
                continue;
            }
            for(int adj:graph[node]) {
                s.push(adj);
            }
        }
        return res;
    }
}