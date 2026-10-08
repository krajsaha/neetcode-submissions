class Solution {
 
    int robber(int[] nums,int idx,int len,HashMap<Integer,Integer> map){
        if(idx>len){
            return 0;
        }
        if(map.containsKey(idx)){
            return map.get(idx);
        }

        int taken = nums[idx]+robber(nums,idx+2,len,map);
        int notTaken = robber(nums,idx+1,len,map);
        map.put(idx,Math.max(taken,notTaken));
        return  map.get(idx);
    }
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(robber(nums,0,nums.length-2,new HashMap<>()),robber(nums,1,nums.length-1,new HashMap<>()));
    }
}
