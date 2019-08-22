// https://leetcode.com/problems/employee-free-time/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start,int _end) {
        start = _start;
        end = _end;
    }
};
*/
class employee-free-time {
    // tc -> nlogn, sc-> n
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        if(schedule==null || schedule.size()==0) return res;
        PriorityQueue<Interval> pq
            = new PriorityQueue<>(
            new Comparator<Interval>(){
                @Override
                public int compare(Interval a, Interval b){
                    return a.start - b.start;
                }
            }
        );
        
        for(List<Interval> list : schedule){
            for(Interval i : list){
                pq.add(i);
            }
        }
        
        Interval temp = pq.poll();
        while(!pq.isEmpty()){
            if(temp.end < pq.peek().start){ // no intersection
                res.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll();
            }else{ // intersection
                temp = temp.end>pq.peek().end ? temp : pq.peek();
                pq.poll();
            }
        }
        return res;
    }
}
