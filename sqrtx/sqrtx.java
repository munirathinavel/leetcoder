class Solution {
    public int mySqrt(int x) {
        if(x < 2) {
            return x;
        }
        long num;
        int l = 2, r = x/2;
        while(l <= r) {
            int mid = l + (r-l)/2;
            num = (long)mid*mid;
            if(num > x) {
                r = mid -1;
            } else if(num < x) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return r;
        
    }
}