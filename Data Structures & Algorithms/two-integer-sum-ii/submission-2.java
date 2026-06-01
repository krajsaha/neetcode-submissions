class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int s=0;
        int e=numbers.length-1;

        while(s<e){
            int data = numbers[s]+numbers[e];
            if(data==target){
                return new int[]{s+1,e+1};
            }else if(data>target){
                e--;
            }else{
                s++;
            }
        }

        return new int[]{};
    }
}
