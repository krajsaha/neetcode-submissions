class Solution {
    public int rob1(int[] nums,int idx,Map<Integer,Integer> map) {
        if(idx>=nums.length){
            return 0;
        }
        if(map.containsKey(idx)){
            return map.get(idx);
        }
        // int stolen=nums[idx];

        int stolen =  Math.max(nums[idx]+rob1(nums,idx+2,map),rob1(nums,idx+1,map));
        map.put(idx,stolen);
        return stolen;

        
    }
    public int rob(int[] nums) {
        return rob1(nums,0,new HashMap<>());

        
    }
}
