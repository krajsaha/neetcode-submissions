class Solution {
    void par(List<String> op,StringBuffer sb,int on,int cn){
        if(on==0 && cn ==0){
            op.add(sb.toString());
        }
        if(on<0 || cn<0){
            return;
        }

        if(on==cn){
            sb.append("(");
            par(op,sb,on-1,cn);
            sb.deleteCharAt(sb.length() - 1);
        }else{
            sb.append("(");
            par(op,sb,on-1,cn);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            par(op,sb,on,cn-1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> op = new ArrayList<>();
            par(op,new StringBuffer(),n,n);
        return op;
    }
}
