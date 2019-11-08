// https://leetcode.com/problems/counting-bits/

class counting-bits {
// tc -> nk, for each integer we need k operations where k is the number of bits in integer.
    // sc-> n
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for(int i=0; i<=num; i++){
            ans[i] = getCount(i);
        }
        return ans;
    }
    
    private int getCount(int num){
        int count = 0;
        while(num!=0){
            count += num&1;
            num >>>= 1;
        }
        return count;
    }
    
    // tc -> n, sc-> n
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=0; i<=num; i++){
            if((i&1)==0){
                res[i] = res[i >> 1];                 
            }else{
                res[i] = res[i-1]+1;
            }
        }
        return res;
    }
}

/*
Prerequisite

As we know, a number can be classified into an even or odd number.

An even number in binary ends with 0

An odd number in binary ends with 1

Strategy

Let's denote the number as num:

If it is even, the ending bit is 0, then that bit can be ignored, countBits(num) is the same as countBits(num >> 1), so countBits(num) = countBits(num >> 1);

For example:

num:      101010101010
num >> 1: 10101010101
If it is odd, the ending bit is 1, then the number of set bits is that of num - 1 + 1, i.e. countBits(num) = countBits(num - 1) + 1

For example:

num:     101010101011
num - 1: 101010101010
*/
