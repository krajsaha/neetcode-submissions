class Solution {
    public int removeElement(int[] nums, int val) {

        if(nums.length==0){
            return 0;
        }
        int s=0;
        int e=nums.length-1;

        while(s<=e){

            while(s<=e && nums[s]!=val){
                s++;
            }
            while(s<=e && nums[e]==val){
                e--;
            }
            if(s<=e) {
                int temp = nums[e];
                nums[e] = nums[s];
                nums[s] = temp;
                s++;
            e--;
            }
            
        }

        return s;
    }
}