class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i : nums){

            set.add(i);
        }
        int res=0;

        for(int i: nums){

            if(set.contains(i-1)){
                continue;
            }

            int maxC=0;
            int ti=i;
            while(set.contains(ti)){
                maxC+=1;
                res=Math.max(res,maxC);
                ti+=1;
            }
        }

        return res;
    }
}
