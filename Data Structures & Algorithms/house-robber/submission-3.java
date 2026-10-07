class Solution {
    int ans(int[] nums,int idx,int[] memo){
        if(idx>=nums.length){
            return 0;
        }
        if(memo[idx]!=-1){
            return memo[idx];
        }

        int taken = nums[idx] + ans(nums,idx+2,memo);
        int notTaken = ans(nums,idx+1,memo);

        return memo[idx] = Math.max(taken,notTaken);
    }
    public int rob(int[] nums) {
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo,-1);
        return ans(nums,0,memo);
    }
}
