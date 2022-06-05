public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap < Integer, List < String >> map = new HashMap < > ();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j))
                        map.put(i + j, new ArrayList < String > ());
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int min_index_sum = Integer.MAX_VALUE;
        for (int key: map.keySet())
            min_index_sum = Math.min(min_index_sum, key);
        String[] res = new String[map.get(min_index_sum).size()];
        return map.get(min_index_sum).toArray(res);
    }
}


// class Solution {
//     public String[] findRestaurant(String[] list1, String[] list2) {
//         Map<String, Integer> map = new HashMap<>();
//         for(int i=0 ; i < list1.length; i++) {
//             String name = list1[i];
//             map.put(name, i);
//         }
//         int leastListIndexSum = Integer.MAX_VALUE;
//         Map<String, Integer> resMap = new HashMap<>();
//         for(int i = 0; i < list2.length; i++) {
//             String name = list2[i];
//             if(map.containsKey(name)) {
//                 int indexSum = i+ map.get(name);
//                 if(leastListIndexSum > indexSum) {
//                     leastListIndexSum = indexSum;
//                 }
//                 resMap.put(name, indexSum);
//             }
//         }
//         List<String> res = new ArrayList<>();
//         for(Map.Entry<String, Integer> entry: resMap.entrySet()){
//             if(entry.getValue() == leastListIndexSum) {
//                 res.add(entry.getKey());
//             }
//         }
//         System.out.println(resMap);
//         return res.toArray(new String[0]);
//     }
// }