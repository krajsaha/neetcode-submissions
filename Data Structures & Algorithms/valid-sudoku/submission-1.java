class Solution {
    public boolean isValidSudoku(char[][] board) {

        int rows = board.length;
        int cols = board[rows-1].length;
        
        Set<String> set = new HashSet<>();

          for(int i = 0;i<rows;i++) {
            
            for(int j = 0;j<cols;j++) {

                if(board[i][j]!='.'){

                String row = "row"+board[i][j]+"-"+i;
                String col = "col"+board[i][j]+"-"+j;
                String box = "box"+board[i][j]+"-"+(i/3)+"-"+(j/3);

            if(!set.add(row) || !set.add(col) ||!set.add(box)) {
                return false;
            }
            }
            }
          }

          return true;

        
    }
}
