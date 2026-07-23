class Solution {
    void getPerm(int[] nums,int[] visited,List<List<Integer>> fop, List<Integer> op) {

        if(op.size()==nums.length) {
            fop.add(new ArrayList<>(op));
            return;
        }

        for(int i =0;i<nums.length;i++) {
            if(visited[i]==0) {
                op.add(nums[i]);
                visited[i] = 1;
                getPerm(nums, visited, fop, op);
                visited[i]=0;
                op.remove(op.size()-1);
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> fop = new ArrayList<>();
         List<Integer> op = new ArrayList<>();
         int[] visited = new int[nums.length];
         getPerm(nums, visited, fop, op);
        return fop;

    }
}