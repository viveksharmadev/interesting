// https://leetcode.com/problems/course-schedule/

class course-schedule {
    // tc -> V+E, sc-> V
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> degreeMap = new HashMap<>();
        for(int[] p : prerequisites){
            degreeMap.put(p[0], degreeMap.getOrDefault(p[0],0)+1);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(degreeMap.getOrDefault(i,0)==0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int course = q.poll();
            numCourses--;
            for(int[] p : prerequisites){
                if(p[1]==course && degreeMap.containsKey(p[0])){
                    degreeMap.put(p[0], degreeMap.get(p[0])-1);
                    if(degreeMap.get(p[0])==0) q.offer(p[0]);
                }
            }
        }
        return numCourses==0;
    }
}
