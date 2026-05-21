class Solution {
    public int majorityElement(int[] nums) {
        int maxE=nums[0];
        int maxV=1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }

            if(map.get(i)>maxV){
                maxE=i;
                maxV=map.get(i);
            }
        }
        return maxE;
    }
}