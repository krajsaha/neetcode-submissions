class Solution {
    public int maxArea(int[] heights) {
        int s =0;
        int e = heights.length-1;
        int ans=-1;
        while(s<e){

            ans = Math.max(ans,(e-s)*Math.min(heights[s],heights[e]));

            if(heights[s]<heights[e]){
                s++;
            }else if(heights[e]<heights[s]){
                e--;
            }else{
                s++;
                e--;
            }

        }

        return ans;
    }
}
