

class Solution {
    private final class RowCol {
    private int row, col;

    public RowCol(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public int hashCode() {
      int result = (int) (row ^ (row >>> 32));
      return (result << 5) - 1 + (int) (col ^ (col >>> 32)); // 31 * result == (result << 5) - 1
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null) return false;
      if (this.getClass() != o.getClass()) return false;

      RowCol rowCol = (RowCol) o;
      return row == rowCol.row && col == rowCol.col;
    }
  }
    Map<RowCol, Integer> res = new HashMap<>();
     public List<Integer> getRow(int row) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int col = 0; col <= row; col++) {
            list.add(getRow(row, col));
        }
        return list;
    }
    
    private int getRow(int row, int col) {
        if(row == 0 || col == 0 || row == col) {
            return 1;
        }
        RowCol key = new RowCol(row, col);
        if(res.containsKey(key)) {
            return res.get(key);
        }
        int val = getRow(row-1, col-1) + getRow(row-1, col);
        res.put(key, val);
        return val;
     }
}
