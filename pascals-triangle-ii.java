// https://leetcode.com/problems/pascals-triangle-ii/
class pascals-triangle-ii {
    // tc -> (rowIndex+1)^2, sc-> (rowIndex+1)^2
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<rowIndex+1; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || i==j){
                    list.add(1);
                }else{
                    int a = res.get(i-1).get(j);
                    int b = res.get(i-1).get(j-1);
                    list.add(a+b);
                }
            }
            res.add(list);
        }
        return res.get(rowIndex);
    }
}
