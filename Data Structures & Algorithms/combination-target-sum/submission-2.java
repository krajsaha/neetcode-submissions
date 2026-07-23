class Solution {
    void rc(List<List<Integer>> fop,List<Integer> op,int idx,int target,int[] nums){

        if(idx>=nums.length){
            return;
        }

        if(target==0){
            fop.add(new ArrayList<>(op));
            return;
        }

        if(nums[idx]>target){
            rc(fop,op,idx+1,target,nums);
        }else{
          
            op.add(nums[idx]);
            rc(fop,op,idx,target-nums[idx],nums);
            op.remove(op.size()-1);
            rc(fop,op,idx+1,target,nums);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> op = new ArrayList<>();
        List<List<Integer>> fop = new ArrayList<>();

        rc(fop,op,0,target,nums);

        return fop;
    }
}
