class Solution {
    void ans(List<List<Integer>> op, List<Integer> top,int idx,int[] nums){
        if(idx==nums.length){
            op.add(new ArrayList<>(top));
            return;
        }

        top.add(nums[idx]);
        ans(op,top,idx+1,nums);
        top.remove(top.size()-1);
        ans(op,top,idx+1,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> op = new ArrayList<>();
        ans(op,new ArrayList<>(),0,nums);
        return op;
    }
}
