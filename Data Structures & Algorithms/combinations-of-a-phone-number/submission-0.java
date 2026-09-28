class Solution {
       void  comb(List<String> op,String digit,int idx,StringBuffer top,Map<Character,String> map) {
//           if (idx == digit.length()) {
//               op.add(top.toString());
//               return;
//           }
           if (top.toString().length()== digit.length()) {
               op.add(top.toString());
               return;
           }
           while(idx<digit.length()){
           char c = digit.charAt(idx);
           idx++;
           String s = map.get(c);
           for (int i = 0; i < s.length(); i++) {
                top.append( s.charAt(i));
                comb(op, digit, idx, top, map);
                top.deleteCharAt(top.length()-1);
           }
       }
    }
    public List<String> letterCombinations(String digits) {
           if(digits.length()==0){
               return new ArrayList<>();
           }
        Map<Character,String> map = new HashMap<>();
        map.put('0'," ");
        map.put('1',"@");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        map.put('*',"+");
        map.put('#',"#");
        List<String> op = new ArrayList<>();
        int[] idx = {0};
        comb(op,digits,0,new StringBuffer(),map);
        return op;

    }
}