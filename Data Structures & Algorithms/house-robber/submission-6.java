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
        // int[] memo = new int[nums.length+1];
        // Arrays.fill(memo,-1);
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] memo = new int[nums.length];
        memo[0]=nums[0];
        int prev2=nums[0];
        memo[1]=Math.max(nums[0],nums[1]);
        int prev1=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            memo[i]=Math.max(nums[i]+memo[i-2],memo[i-1]);
            int curr=Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=curr;
        }
        // return ans(nums,0,memo);
        // return memo[nums.length-1];
        return prev1;

    }

}
