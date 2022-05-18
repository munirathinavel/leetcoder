/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0, r = Integer.MAX_VALUE;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            int val = reader.get(mid);
            // System.out.println("val=" + val + ", left=" + l + ", mid=" + mid  + ", right=" + r);
            if( val == target) {
                return mid;
            } else if(val == Integer.MAX_VALUE || val > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}