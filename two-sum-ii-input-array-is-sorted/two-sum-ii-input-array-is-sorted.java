class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int p1 = 0, p2 = n-1;
        while( p1 < p2 ) {
            int sum = numbers[p1] + numbers[p2];
            if(sum > target) {
                p2--;
            } else if(sum  < target) {
                p1++;
            } else {
                break;
            }
        }
        return new int[]{p1+1, p2+1};
    }
}