// Time Complexity - O(N.log(N) + k.log(k))
//Space Complexity
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> sortedArray = new ArrayList<>();
        for(int num: arr) {
            sortedArray.add(num);
        }
        Collections.sort(sortedArray, (n1, n2) -> Math.abs(n1-x) - Math.abs(n2 - x));
        sortedArray = sortedArray.subList(0,k);
        Collections.sort(sortedArray);
        return sortedArray;
    }
}


// Time Complexity - O(log(N-k) + k)
//Space Complexity - 1
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         int l = 0, r = arr.length - k;
//         while(l < r) {
//             int mid = l + (r-l) / 2;
//             if(x - arr[mid] > arr[mid+k] -x) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return Arrays.stream(arr, l, l+k).boxed().collect(Collectors.toList());
//     }
// }