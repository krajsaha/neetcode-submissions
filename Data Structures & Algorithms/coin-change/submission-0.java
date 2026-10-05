class Solution {
       int ans(int[] coins,int amount,int idx,int[][] memo){
           if(idx>=coins.length || amount<0){
               return Integer.MAX_VALUE-1;
           }

           if(amount==0){
               return 0;
           }

           if(memo[idx][amount]!=-1){
               return memo[idx][amount];
           }

           if(coins[idx]>amount){
               return memo[idx][amount] = ans(coins,amount,idx+1,memo);
           }else {
               return memo[idx][amount] = Math.min(ans(coins,amount-coins[idx],idx,memo)+1,ans(coins,amount,idx+1,memo));
           }

       }
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length+1][amount+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int ans1 = ans(coins,amount,0,memo);
    return ans1==Integer.MAX_VALUE-1 ? -1 : ans1;
    }
}