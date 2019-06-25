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
}
