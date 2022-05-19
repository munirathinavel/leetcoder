class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2) {
           return true;
        }
        long l = 2, r = num/2;
        while(l <= r) {
            long m = l + (r-l) / 2;
            long ans = m * m;
            if(ans == num) {
                return true;
            } else if(ans > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}