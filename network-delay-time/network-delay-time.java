class Solution {
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        
        for(int[] time:times) {
            int src = time[0];
            int dest = time[1];
            int weight = time[2];

            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(new Pair(weight, dest));
        }
        int[] signal = new int[n+1];
        Arrays.fill(signal, Integer.MAX_VALUE);
        
        dijkstra(signal,  n, k);
        
        int ans = Integer.MIN_VALUE;
        for(int i=1; i <= n; i++) {
            ans = Math.max(ans, signal[i]);
        }
        
        return ans == Integer.MAX_VALUE? -1 : ans;
    }
    
    private void dijkstra(int[] signal, int n, int src){
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(Comparator.comparing(Pair::getKey));
        pq.add(new Pair(0, src));
        signal[src] = 0;
        
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.remove();
            int currNode = pair.getValue();
            int currNodeTime = pair.getKey();
            
            if(currNodeTime > signal[currNode] || !adj.containsKey(currNode)) {
                continue;
            }
            
            for(Pair<Integer, Integer> edge: adj.get(currNode)) {
                int time = edge.getKey();
                int next = edge.getValue();
                if(signal[next] > currNodeTime + time) {
                    signal[next] = currNodeTime + time;
                    pq.add(new Pair(signal[next], next));
                }
            }
        }
    }
}