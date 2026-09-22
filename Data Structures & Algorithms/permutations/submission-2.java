class Solution {
    void perm(List<List<Integer>> op,List<Integer> top,int[] nums,boolean[] visited){
        if(top.size()==nums.length){
            op.add(new ArrayList<>(top));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                top.add(nums[i]);
                perm(op,top,nums,visited);
                top.remove(top.size()-1);
                visited[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
         List<Integer> top = new ArrayList<>();
         boolean[] visited = new boolean[nums.length];
         perm(op,top,nums,visited);
        return op;
    }
}
