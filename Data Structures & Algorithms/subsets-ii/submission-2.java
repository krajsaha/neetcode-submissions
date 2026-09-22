class Solution {
    void sol(List<List<Integer>> op, List<Integer> top,int[] nums,int idx){
        if(idx>=nums.length){
            op.add(new ArrayList<>(top));
            return;
        }
        int currVal = nums[idx];
        top.add(currVal);
        sol(op,top,nums,idx+1);
        top.remove(top.size()-1);
        while(idx<nums.length && nums[idx]==currVal){
            idx+=1;
        }
        sol(op,top,nums,idx);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> op = new ArrayList<>();
        sol(op,new ArrayList<>(),nums,0);
        return op;
    }
}
