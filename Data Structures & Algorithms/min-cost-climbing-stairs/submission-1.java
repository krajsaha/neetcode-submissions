class Solution {
    int costs(int[] cost,int idx,Map<Integer,Integer> map){
        if(idx>=cost.length){
            return 0;
        }
        if(map.containsKey(idx)){
            return map.get(idx);
        }
        int costi = cost[idx];
        int fn =  Math.min(costs(cost,idx+1,map),costs(cost,idx+2,map))+costi;
        map.put(idx,fn);
        return fn;
    }
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer,Integer> map = new HashMap<>();
        return Math.min(costs(cost,0,map),costs(cost,1,map));
        // int ans[] = new int[cost.length];
        // ans[0]=cost[0];
        // ans[1]=cost[1];
        //  int size = cost.length;
        // for(int i=2;i<cost.length;i++){
        //     ans[i]=Math.min(ans[i-1],ans[i-2])+cost[i];
        // }
        // return Math.min(ans[size-1],ans[size-2]);
        // int n = cost.length;
        // int[] dp = new int[n + 1];

        // for (int i = 2; i <= n; i++) {
        //     dp[i] = Math.min(dp[i - 1] + cost[i - 1],
        //                      dp[i - 2] + cost[i - 2]);
        // }

        // return dp[n];
    }
}
