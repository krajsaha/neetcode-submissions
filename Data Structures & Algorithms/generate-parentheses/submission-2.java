class Solution {
    void par(List<String> op,String sb,int on,int cn){
        if(on==0 && cn ==0){
            op.add(sb);
        }
        if(on<0 || cn<0){
            return;
        }

        if(on==cn){
            String osb = sb+"(";
            par(op,osb,on-1,cn);
        }else{
            String osb = sb+"(";
            par(op,osb,on-1,cn);
            String csb = sb+")";
            par(op,csb,on,cn-1);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> op = new ArrayList<>();
            par(op,"",n,n);
        return op;
    }
}
