https://leetcode.com/problems/goat-latin/
class goat-latin {
    // tc -> n, sc-> n
    public String toGoatLatin(String S) {
        String[] arr = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            if(arr[i].charAt(0)=='a' || arr[i].charAt(0)=='e'
              || arr[i].charAt(0)=='i' || arr[i].charAt(0)=='o'
              || arr[i].charAt(0)=='u' || arr[i].charAt(0)=='A'
              || arr[i].charAt(0)=='E' || arr[i].charAt(0)=='I' 
              || arr[i].charAt(0)=='O' || arr[i].charAt(0)=='U'){
                sb.append(arr[i]);
            }else{
                sb.append(arr[i].substring(1))
                    .append(arr[i].charAt(0)+"");
            }
            sb.append("ma");
            int j = 0;
            while(j<=i){
                sb.append("a");
                j++;
            }
            if(i!=arr.length-1)
            sb.append(" ");
        }
        return sb.toString();
    }
}
