class Solution {
    public int maxProfit(int[] prices) {
        int maxp=0;
        int bp=prices[0];

        for(int i : prices){

            maxp=Math.max(maxp,i-bp);
            bp=Math.min(bp,i);
        }

        return maxp;
    }
}
