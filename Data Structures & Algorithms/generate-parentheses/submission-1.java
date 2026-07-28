class Solution {
    void rec(int s,int c , List<String> op, StringBuffer sb){

        if(s==0 && c==0){
            op.add(new String(sb.toString()));
            return;
        }

        if(s==c){
            sb.append('(');
            rec(s-1,c,op,sb);
            sb.deleteCharAt(sb.length() - 1);
        }else if(s==0 && c>0){
            sb.append(')');
            rec(s,c-1,op,sb);
            sb.deleteCharAt(sb.length() - 1);
        }else{
            sb.append('(');
            rec(s-1,c,op,sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            rec(s,c-1,op,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
         ArrayList<String> op = new ArrayList<>();
          StringBuffer sb = new StringBuffer();
        rec(n,n,op,sb);
        return op;
    }
}
