class Pair{
    int val;
    int idx;
    Pair(int v,int i){
        val=v;
        idx=i;

    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int[] op = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){

            while(!stack.isEmpty() && temperatures[i]>stack.peek().val){
                Pair tp= stack.pop();
                op[tp.idx] = i - tp.idx;
            }

            stack.push(new Pair(temperatures[i],i));
        }

        return op;
    }
}
