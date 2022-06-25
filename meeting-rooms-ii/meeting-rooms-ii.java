class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length);
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] -b[0];
            }
        });
        
        pq.offer(intervals[0][1]);
        for(int i=1; i < intervals.length; i++) {
            if(intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        
        return pq.size();
    }
}