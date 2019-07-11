// https://leetcode.com/problems/median-of-two-sorted-arrays/
class median-of-two-sorted-arrays {
    // tc -> m+n, sc-> m+n
    // Need to add optimized method
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length; double res = 0.0;
        int[] arr = merge(nums1, nums2, m-1, n-1);
        //for(int a : arr) System.out.println(a);
        int mid = arr.length/2;
        //System.out.println(mid);
        if((m+n)%2==0){
            res = (arr[mid]+arr[mid-1])/2.0;
        }else{
            res = arr[mid];
        }
        return res;
    }
    
    private int[] merge(int[] arr1, int[] arr2, int m, int n){
        int l = arr1.length+arr2.length;
        int[] arr = new int[l];l=l-1;
        while(m>=0 && n>=0){
           if(arr1[m]>arr2[n]){
                arr[l--] = arr1[m--];
            }else{
                arr[l--] = arr2[n--];
            }
        }
        while(m>=0) arr[l--] = arr1[m--];
        while(n>=0) arr[l--] = arr2[n--];        
        return arr;
    }
    
// Optimized :    
/* Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.

Time complexity is O(log(min(x,y))
 * Space complexity is O(1)*/
    // tc -> m+n, sc-> m+n
    public double findMedianSortedArrays(int input1[], int input2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }
}
