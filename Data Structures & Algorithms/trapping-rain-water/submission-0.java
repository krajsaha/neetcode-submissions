class Solution {
    public int trap(int[] height) {
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];
        int ans=0;

        int l=-1;
        int r=-1;

        for(int i=0;i<height.length;i++){
            if(l<height[i]){
                lmax[i]=-1;
            }else{
                lmax[i]=l;
            }
            l=Math.max(l,height[i]);
        }

        for(int i=height.length-1;i>=0;i--){
            if(r<height[i]){
                rmax[i]=-1;
            }else{
                rmax[i]=r;
            }
            r=Math.max(r,height[i]);
        }

        for(int i=0;i<height.length;i++){
            ans+=Math.max(0,Math.min(lmax[i],rmax[i])-height[i]);
        }
        return ans;
    }
}