class Solution {
  enum Color { GRAY, BLACK };
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = buildDigraph(n, edges);
        return leadsToDest(graph, source, destination, new Color[n]);
    }
    
    private boolean leadsToDest(List<Integer>[] graph, int src, int dest, Color[] states ) {
        if(states[src] != null) {
            return states[src] == Color.BLACK;
        }
        if(graph[src].isEmpty()) {
            return src == dest;
        }
        states[src] = Color.GRAY;
        for(int adj:graph[src]) {
            if(!leadsToDest(graph, adj, dest, states)) {
                return false;
            }
        }
        states[src] = Color.BLACK;
        return true;
    }
    
    
    private List<Integer>[] buildDigraph(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        for(int i =0; i < n;i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] edge:edges) {
            g[edge[0]].add(edge[1]);
        }
        return g;
    }
}