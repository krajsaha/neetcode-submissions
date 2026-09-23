class Solution { 
    boolean exists(char[][] board,int c,int r,int cmax,int rmax,String word,StringBuffer sb,boolean[][] visited){
        if(sb.length()==word.length()){
            return sb.toString().equals(word);
        }

        if(c<0 || c>=cmax || r<0 || r>=rmax || visited[r][c]){
            return false;
        }
        boolean flag=false;

        visited[r][c]=true;
        sb.append(board[r][c]);
        flag= flag || exists(board,c+1,r,cmax,rmax,word,sb,visited);
        visited[r][c]=false;
        sb.deleteCharAt(sb.length()-1);
        visited[r][c]=true;
        sb.append(board[r][c]);
        flag= flag || exists(board,c,r+1,cmax,rmax,word,sb,visited);
        visited[r][c]=false;
        sb.deleteCharAt(sb.length()-1);
        visited[r][c]=true;
        sb.append(board[r][c]);
        flag= flag || exists(board,c-1,r,cmax,rmax,word,sb,visited);
        visited[r][c]=false;
        sb.deleteCharAt(sb.length()-1);
        visited[r][c]=true;
        sb.append(board[r][c]);
        flag= flag || exists(board,c,r-1,cmax,rmax,word,sb,visited);
        visited[r][c]=false;
        sb.deleteCharAt(sb.length()-1);
        return flag;

    }
    public boolean exist(char[][] board, String word) {
        int rmax=board.length;
        int cmax=board[rmax-1].length;
        boolean[][] visited = new boolean[rmax][cmax];
        StringBuffer sb = new StringBuffer();
        char sc= word.charAt(0);
        boolean flag=false;
        for(int i=0;i<rmax;i++){
            for(int j=0;j<cmax;j++){
                if(board[i][j]==sc){
                    flag=flag || exists(board,j,i,cmax,rmax,word,sb,visited);
                }
            }
        }
        return flag;
    }
}
