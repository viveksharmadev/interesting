// https://leetcode.com/problems/peeking-iterator/

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    // tc -> 1, sc-> n
    private Iterator<Integer> itr;
    private Integer next;
    private boolean isDone;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        itr = iterator;
	    if(itr.hasNext()){
            next = itr.next();
        }else{
            isDone = true;
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
       return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer result = next;
	    if(itr.hasNext()){
            next = itr.next();
        }else{
            next = null;
            isDone = true;
        }
        return result;
	}

	@Override
	public boolean hasNext() {
	    return !isDone;
	}
}
