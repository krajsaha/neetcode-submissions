class Solution {
    public int maxProfit(int[] prices) {
        int maxProf=0;

        int minBuy=prices[0];

        for(int i : prices){

            if((i-minBuy)>maxProf){
                maxProf=i-minBuy;
            }

            if(i<minBuy){
                minBuy=i;
            }
        }

        return maxProf;
    }
}
