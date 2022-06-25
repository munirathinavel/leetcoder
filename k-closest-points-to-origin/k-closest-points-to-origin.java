class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i=0; i < points.length; i++) {
            int[] entry = {points[i][0]*points[i][0] + points[i][1] * points[i][1], i};
            if(pq.size() < k) {
                pq.add(entry);
            } else if(entry[0] < pq.peek()[0]) {
                pq.poll();
                pq.add(entry);
            }
        }
        int[][] res = new int[k][2];
        for(int i =0; i < k; i++) {
            res[i] = points[pq.poll()[1]];
        }
        return res;
    }
}