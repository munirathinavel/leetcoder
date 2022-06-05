class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0 ; i < list1.length; i++) {
            String name = list1[i];
            map.put(name, i);
        }
        int leastListIndexSum = Integer.MAX_VALUE;
        Map<String, Integer> resMap = new HashMap<>();
        for(int i = 0; i < list2.length; i++) {
            String name = list2[i];
            if(map.containsKey(name)) {
                int indexSum = i+ map.get(name);
                if(leastListIndexSum > indexSum) {
                    leastListIndexSum = indexSum;
                }
                resMap.put(name, indexSum);
            }
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: resMap.entrySet()){
            if(entry.getValue() == leastListIndexSum) {
                res.add(entry.getKey());
            }
        }
        System.out.println(resMap);
        return res.toArray(new String[0]);
    }
}