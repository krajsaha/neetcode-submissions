class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int s=0;
        int e=0;
        int[] op = new int[nums.length+1 - k];
        Deque <Integer> dq = new ArrayDeque<>();
        while(e<nums.length){

            // Think of monotonic stack
            // we are only keeping the max value
            while(!dq.isEmpty() && nums[e]>dq.peekFirst()){
                dq.removeFirst();
            }

            dq.addFirst(nums[e]);

            if((e-s)+1==k){
                //i have hit za window
                op[s]=dq.peekLast();
                if(nums[s]==dq.peekLast()){
                    dq.removeLast();
                }
                s++;
            }

            e++;
        }

        return op;
    }
}
