class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //sort array
        //process only 1 of the duplicates skip the next
        // for rest of the element normal two sum
        // inbetween the two sum if we find aresult skip the next duplicates
        //sort array
        Arrays.sort(nums);
        List<List<Integer>> fop = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++) {
            //remove duplicate stage 1
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int target = 0 - nums[i];

            int s=i+1;
            int e=nums.length-1;

            while(s<e){

                if(nums[i]+nums[s]+nums[e]==0){
                    ArrayList<Integer> op = new ArrayList<>();
                    op.add(nums[i]);
                    op.add(nums[s]);
                    op.add(nums[e]);
                    fop.add(op);
                    //remove duplicate stage 2
                    while(s<e && nums[e]==nums[e-1]){
                        e--;
                    }
                    //remove duplicate stage 3
                    while(s<e && nums[s]==nums[s+1]){
                        s++;
                    }
                    //normal two sum
                    s++;
                    e--;

                }
                //normal two sum
                else if(nums[s]+nums[e]>target){
                    e--;
                }else{
                    s++;
                }
            }
        }
        return fop;
    }
}
