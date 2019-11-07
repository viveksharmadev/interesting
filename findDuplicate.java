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

/*
Follow up questions:

1. Imagine you are given a real file system, how will you search files? DFS or BFS ?
In general, BFS will use more memory then DFS. However BFS can take advantage of the locality of files in inside directories, and therefore will probably be faster

2. If the file content is very large (GB level), how will you modify your solution?
In a real life solution we will not hash the entire file content, since it's not practical. Instead we will first map all the files according to size. Files with different sizes are guaranteed to be different. We will than hash a small part of the files with equal sizes (using MD5 for example). Only if the md5 is the same, we will compare the files byte by byte

3. If you can only read the file by 1kb each time, how will you modify your solution?
This won't change the solution. We can create the hash from the 1kb chunks, and then read the entire file if a full byte by byte comparison is required.

What is the time complexity of your modified solution? What is the most time consuming part and memory consuming part of it? How to optimize?
Time complexity is O(n^2 * k) since in worse case we might need to compare every file to all others. k is the file size

How to make sure the duplicated files you find are not false positive?
We will use several filters to compare: File size, Hash and byte by byte comparisons.
*/
