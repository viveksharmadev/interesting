// https://leetcode.com/problems/find-duplicate-file-in-system/
class findDuplicate {
    // tc -> n*x, sc-> n*x
    // where n strings of average length of x
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new LinkedList<>();
        if(paths==null || paths.length==0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] dir = path.split(" ");
            String root = dir[0];
            for(int i=1; i< dir.length; i++){
                int openBrace = dir[i].indexOf("(");
                int closeBrace = dir[i].indexOf(")");
                String content = dir[i].substring(openBrace, closeBrace+1);
                map.putIfAbsent(content, new LinkedList<>());
                map.get(content).add(root+"/"+dir[i].substring(0, openBrace));
            }
        }
        
        for(String key : map.keySet()){
            if(map.get(key).size()>1)
            res.add(map.get(key));    
        }
        
        return res;
    }
}
