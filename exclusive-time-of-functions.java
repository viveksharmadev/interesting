// https://leetcode.com/problems/exclusive-time-of-functions/
class exclusive-time-of-functions {
    // tc -> n, sc-> n
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        for(String log : logs){
            String[] parts = log.split(":");
            if(parts[1].equals("start")){
                if(!stack.isEmpty())
                    res[stack.peek()] += Integer.parseInt(parts[2]) - prev;
                    prev = Integer.parseInt(parts[2]);
                    stack.push(Integer.parseInt(parts[0]));
            }else if(parts[1].equals("end")){
                    if(!stack.isEmpty())
                    res[stack.pop()] += Integer.parseInt(parts[2]) - prev + 1;
                    prev = Integer.parseInt(parts[2]) + 1;                    
                }
            }
        return res;
        }
        
    }
