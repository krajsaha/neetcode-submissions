class Solution {
    void sum(List<List<Integer>> op,List<Integer> top,int[] candidates,int target,int idx){
        if(target==0){
            op.add(new ArrayList<>(top));
            return;
        }
        if(idx>=candidates.length || target<0){
            return;
        }
       

        if(candidates[idx]>target){
            int currentVal=candidates[idx];
            while(idx<candidates.length && candidates[idx]==currentVal){
                idx+=1;
            }
            sum(op,top,candidates,target,idx);
        }else{
            top.add(candidates[idx]);
            sum(op,top,candidates,target-candidates[idx],idx+1);
            top.remove(top.size()-1);
            int currentVal=candidates[idx];
            while(idx<candidates.length && candidates[idx]==currentVal){
                idx+=1;
            }
            sum(op,top,candidates,target,idx);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
List<List<Integer>> op = new ArrayList<>();
sum(op,new ArrayList<>(),candidates,target,0);
return op;
    }
}
