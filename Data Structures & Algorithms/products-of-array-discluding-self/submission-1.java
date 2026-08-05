class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] ans = new int[nums.length];
        int count=1;
        ans[0]=count;
        ans[ans.length-1]=count;

        for(int i=1;i<nums.length;i++){
            count=nums[i-1]*count;
            ans[i]=count;
        }
        count=1;
        for(int i=nums.length-2;i>=0;i--){
            count=nums[i+1]*count;
            ans[i]=ans[i]*count;
        }

        return ans;
    }
}  
