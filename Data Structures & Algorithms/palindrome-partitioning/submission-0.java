class Solution {
    boolean isPalindrome(String t) {
        int l = 0, r = t.length() - 1;
        while (l < r) {
            if (t.charAt(l++) != t.charAt(r--)) return false;
        }
        return true;
    }

       void  subString(String s,int idx,List<List<String>> op,List<String> top){
           if(idx == s.length()){
               op.add(new ArrayList<>(top));
               return;
           }
           for(int i=idx+1;i<=s.length();i++){
               String t = s.substring(idx,i);
               if(isPalindrome(t)){
               top.add(t);
               subString(s,i,op,top);
               top.remove(top.size()-1);
               }
           }
           
    }

    public List<List<String>> partition(String s) {
        List<List<String>> op = new ArrayList<>();
        subString(s,0,op,new ArrayList<>());
        return op;
    }
}