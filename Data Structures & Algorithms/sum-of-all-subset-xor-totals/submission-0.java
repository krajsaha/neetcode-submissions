class Solution {
    void xs(int[] nums,int idx,int[] op,int sum){

        if(idx>=nums.length){
            op[0]+=sum;
            return;
        }

        int newSum = sum^nums[idx];

        xs(nums,idx+1,op,newSum);
        xs(nums,idx+1,op,sum);
    }
    public int subsetXORSum(int[] nums) {
        int[] op = new int[1];
        xs(nums,0,op,0);
        return op[0];
    }
}