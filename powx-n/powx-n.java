class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        long N = n;
        if(N < 0) {
            N = -N;
            x = 1/x;
        }
        double ans = 1;
        double currentAns = x;
        for(long i = N; i > 0; i = i/2) {
            if(i %2 == 1) {
                ans = ans * currentAns;
            }
            currentAns = currentAns * currentAns;
        }
        return ans;
    }
};

// 