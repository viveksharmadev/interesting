// https://leetcode.com/problems/find-median-from-data-stream/
// tc -> 1 for add and findMedian but to instantiate it is nlogn
// sc-> n
class MedianFinder {

    Queue<Integer> lower;
    Queue<Integer> higher;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        lower = new PriorityQueue<>(
            new Comparator<Integer>(){
                @Override
                public int compare(Integer a, Integer b){
                    return b-a;
                }
            }
        );
        
        higher = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        higher.add(num);
        lower.add(higher.poll());
        if(higher.size()<lower.size())
            higher.add(lower.poll());
    }
    
    public double findMedian() {
        return higher.size()>lower.size() ? higher.peek() 
                            : (higher.peek() + lower.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
