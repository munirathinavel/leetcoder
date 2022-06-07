class TwoSum {
    Map<Integer, Integer> map;
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }
    
    public void add(int number) {
         if (this.map.containsKey(number))
          this.map.replace(number, this.map.get(number) + 1);
        else
          this.map.put(number, 1);
    }
    
    public boolean find(int value) {
        for(int key: map.keySet()) {
            int complement = value - key;
            if(complement != key) {
                if(map.containsKey(complement)) {
                    return true;
                }
            }  else {
                if(map.get(key) > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */