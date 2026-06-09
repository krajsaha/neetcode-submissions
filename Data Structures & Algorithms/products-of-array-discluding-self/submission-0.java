class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] op = new int[nums.length];
        int lval=1;
        int rval=1;

        for(int i=0;i<nums.length;i++){
            op[i]=lval;
            lval=lval*nums[i];
        }     
        for(int i=nums.length-1;i>=0;i--){
            op[i]=op[i]*rval;
            rval=rval*nums[i];
        }   

        return op;
    }
}  
