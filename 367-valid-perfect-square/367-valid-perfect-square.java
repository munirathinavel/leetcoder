class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2) {
            return true;
        }
        long l = 2, r = num /2;
        while(l <= r) {
            long  x = l+(r-l)/2;
           long  guess = x * x;
            if(guess == num) {
                return true; 
            } else if(guess < num) {
                l = x + 1;    
            } else {
                r = x - 1;
            }
        }
        return false;
    }
}