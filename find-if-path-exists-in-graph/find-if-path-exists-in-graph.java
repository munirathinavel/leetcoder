class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> g = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<n;i++) {
            g.add(new ArrayList<Integer>());
        }
        System.out.println(g);
        for(int[] edge: edges) {
            int i = edge[0];
            int j = edge[1];
            g.get(j).add(i);
            g.get(i).add(j);
        }
         System.out.println(g);
        Stack<Integer> s = new Stack<>();
        s.push(source);
        
        while(!s.isEmpty()){
            int node = s.pop();
             System.out.println("node=" +node);
            if(node == destination) {
                return true;
            }
            if(visited.contains(node)) {
                continue;
            }
            visited.add(node);
            for(int adj: g.get(node)) {
                s.push(adj);
            }
        }
     return false;   
    }
}
