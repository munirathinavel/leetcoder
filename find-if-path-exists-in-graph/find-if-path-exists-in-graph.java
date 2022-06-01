class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> graph = new ArrayList<>(n);
        for(int i=0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges) {
            graph.get(edge[0]).add(edge[1]); 
            graph.get(edge[1]).add(edge[0]); 
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        
        while(!q.isEmpty()) {
            int current = q.remove();
            if(visited.contains(current)) {
                continue;
            }
            if(current == destination) {
                return true;
            }
            for(int neighbor: graph.get(current)) {
                q.add(neighbor);
            }
            visited.add(current);
        }
        return false;
    }
}
