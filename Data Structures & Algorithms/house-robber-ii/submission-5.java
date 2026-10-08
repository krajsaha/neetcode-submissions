class Solution {

    int robberBU(int[] nums,int sidx,int eidx,int[] memo){

        memo[sidx]=nums[sidx];
        sidx+=1;
        memo[sidx]=Math.max(nums[sidx],nums[sidx-1]);

        for(int i=sidx+1;i<=eidx;i++){

            int taken = nums[i]+memo[i-2];
            int notTaken = memo[i-1];
            memo[i] = Math.max(taken,notTaken);
        }

        return memo[eidx];
    }
 
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
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        // return Math.max(robber(nums,0,nums.length-2,new HashMap<>()),robber(nums,1,nums.length-1,new HashMap<>()));
        
        return Math.max(robberBU(nums,0,nums.length-2,new int[nums.length]),robberBU(nums,1,nums.length-1,new int[nums.length]));
    }
}
