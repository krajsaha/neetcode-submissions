class Solution {

    void rec(List<List<Integer>> fop, List<Integer> op,int idx,int[] nums){

        if(idx==nums.length){
            fop.add(new ArrayList<>(op));
            return;
        }

        op.add(nums[idx]);

        idx+=1;
        rec(fop,op,idx,nums);
        op.remove(op.size()-1);
        int newIdx=idx;
        while(newIdx>0 && newIdx<nums.length && nums[newIdx]==nums[newIdx-1]){
            newIdx+=1;
        }
        rec(fop,op,newIdx,nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> op = new ArrayList<>();
        List<List<Integer>> fop = new ArrayList<>();
        Arrays.sort(nums);
        rec(fop,op,0,nums);
        return fop;
    }
}
