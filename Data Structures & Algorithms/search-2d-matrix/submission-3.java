class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length-1;
        int cols =matrix[rows].length-1;
        int finalRow=-1;

        int s=0;
        int e=rows;

        while(s<=e){

            int mid = s+(e-s)/2;

            if(matrix[mid][0]==target){
                return true;
            }
            if(target>=matrix[mid][0] && target<=matrix[mid][cols]){
                finalRow=mid;
                break;
            }else if(target>matrix[mid][cols]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        if(finalRow==-1){
            return false;
        }
         s=0;
         e=cols;
        while(s<=e){

            int mid = s+(e-s)/2;

            if(matrix[finalRow][mid]==target){
                return true;
            }
            // if(trget>matrix[mid][0] && target<matrix[mid][cols]){
            //     finalRow=mid;
            //     break;
            // }
             if(target>matrix[finalRow][mid]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }

        return false;
    }
}
