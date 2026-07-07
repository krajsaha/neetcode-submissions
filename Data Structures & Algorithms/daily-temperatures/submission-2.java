// class Pair {
//     int temp;
//     int idx;
//     Pair(int temp,int idx){
//         this.temp=temp;
//         this.idx=idx;
//     }
// }
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] op = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++) {

                while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){

                    int temp=stack.pop();
                    op[temp]=i-temp;
                }

                stack.push(i);
            
        }

        return op;
    }
}
