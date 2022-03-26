class Solution {
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        int index = 0;
        for(int[] building: buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].isStart = true;
            buildingPoints[index].x = building[0];
            buildingPoints[index].height = building[2];
            
            buildingPoints[index+1] = new BuildingPoint();
            buildingPoints[index+1].isStart = false;
            buildingPoints[index+1].x = building[1];
            buildingPoints[index+1].height = building[2];
            index+=2;
        }
        Arrays.sort(buildingPoints);
        
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0,1);
        int prevMaxHeight = 0;
        for(BuildingPoint buildingPoint:buildingPoints) {
            if(buildingPoint.isStart) {
                queue.compute(buildingPoint.height, (key, value) -> {
                   if(value == null) {
                       return 1;
                   }  else {
                       return value + 1;
                   }
                });
            } else {
                queue.compute(buildingPoint.height, (key, value) -> {
                    if(value == 1) {
                        return null;
                    } else {
                        return value - 1;
                    }
                });
            }
            int currentHeight = queue.lastKey();
            if(currentHeight != prevMaxHeight) {
                    res.add(Arrays.asList(buildingPoint.x, currentHeight));
                    prevMaxHeight = currentHeight;
            }
        }
        return res;
    }
}

class BuildingPoint implements Comparable<BuildingPoint>{
        int x;
        int height;
        boolean isStart;
        
        @Override
        public int compareTo(BuildingPoint o) {
            if(this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }