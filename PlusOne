class PlusOne {
    public int[] plusOne(int[] digits) {
        int add = 1;
        List<Integer> list = new ArrayList<>();
        int carry =0;
        for(int i=digits.length-1; i>=0; i--){
            int sum = digits[i]+carry + add;
            add =0;
            list.add(0, sum%10);
            carry = sum/10;
        }
        if(carry > 0){
            list.add(0, carry);
        }
        
        int[] res = new int[list.size()]; int i=0;
        for(int num : res){
            res[i++] = num;
        }
        return res;
    }
}
