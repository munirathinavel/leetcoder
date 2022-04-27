// class Solution {
//     public int mySqrt(int x) {
//         if(x < 2) {
//             return x;
//         }
//         long num;
//         int l = 2, r = x/2;
//         while(l <= r) {
//             int mid = l + (r-l)/2;
//             num = (long)mid*mid;
//             if(num > x) {
//                 r = mid -1;
//             } else if(num < x) {
//                 l = mid + 1;
//             } else {
//                 return mid;
//             }
//         }
//         return r;
        
//     }
// }

class Solution {
    public int mySqrt(int x) {
        if(x < 2) {
            return x;
        }
        int l = 2, r = x/2;
        while(l <=r) {
            int mid = l + (r-l) /2;
            long square = (long)mid * mid;
            if(square == x) {
                return mid;
            } else if(square < x) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        return r;
        
    }
}