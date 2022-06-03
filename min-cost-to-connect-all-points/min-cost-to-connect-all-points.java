class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        PriorityQueue<Edge> q = new PriorityQueue<>((e1,e2) -> e1.cost - e2.cost);
        for(int i =0; i < points.length; i++) {
            for(int j = i +1; j<points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int cost = Math.abs(x1-x2) + Math.abs(y1-y2);
                q.add(new Edge(i,j, cost));
            }
        }
        UnionFind uf = new UnionFind(points.length);
        int edge = 0;
        int minCost = 0;
        while(!q.isEmpty() && edge < points.length -1) {
            Edge e = q.poll();
            if(!uf.connected(e.x, e.y)) {
                uf.union(e.x, e.y);
                edge++;
                minCost += e.cost;
            }
        }
        return minCost;
    }
    
    class Edge {
        int x,  y, cost;
        Edge(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}

class UnionFind {
    int root[];
    int rank[];
    UnionFind(int size){
        root = new int[size];
        rank = new int[size];
        for(int i =0;i < size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x) {
        if(x == root[x]) {
           return x;
        }
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if(rootx != rooty) {
            if(rank[rootx] > rank[rooty]) {
                root[rooty] = rootx;
                
            } else if(rank[rootx] < rank[rooty]) {
                root[rootx] = rooty;
            } else {
                root[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

