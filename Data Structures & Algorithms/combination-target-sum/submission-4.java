class Solution {
    void ans(List<List<Integer>> op, List<Integer> top,int idx,int[] nums,int target){
        if(target==0){
            op.add(new ArrayList<>(top));
            return;
        }
        if(idx>=nums.length || target<0){
            return;
        }
        if(nums[idx]>target){
            ans(op,top,idx+1,nums,target);
        }else{

        top.add(nums[idx]);
        
        ans(op,top,idx,nums,target-nums[idx]);
        // target+=top.get(top.size()-1);
        top.remove(top.size()-1);
        ans(op,top,idx+1,nums,target);
    }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
                List<List<Integer>> op = new ArrayList<>();
        ans(op,new ArrayList<>(),0,nums,target);
        return op;
    }
}
