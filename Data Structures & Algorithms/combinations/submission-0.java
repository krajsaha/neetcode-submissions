class Solution {
    void rc(List<List<Integer>> fop, List<Integer> op,int[] nums,int idx,int k){
        if(op.size()==k){
            fop.add(new ArrayList<>(op));
            return;
        }

        if(idx>=nums.length || op.size()>k){
            return;
        }

        

        op.add(nums[idx]);
        rc(fop,op,nums,idx+1,k);
        op.remove(op.size()-1);
        rc(fop,op,nums,idx+1,k);
    }
    public List<List<Integer>> combine(int n, int k) {
        
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
         List<Integer> op = new ArrayList<>();
        List<List<Integer>> fop = new ArrayList<>();

        rc(fop,op,nums,0,k);

        return fop;
    }
}