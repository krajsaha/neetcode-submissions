class Solution {
    void rec(List<List<Integer>> fop,List<Integer> op,int idx,int[] nums){

        if(idx>=nums.length){
            fop.add(new ArrayList<>(op));
            return;
        }
        op.add(nums[idx]);
        idx+=1;
        rec(fop,op,idx,nums);
        op.remove(op.size()-1);
        rec(fop,op,idx,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> op = new ArrayList<>();
        List<List<Integer>> fop = new ArrayList<>();
        rec(fop,op,0,nums);
        return fop;
    }
}
