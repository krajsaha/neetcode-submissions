class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();

        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> op = new ArrayList<>();
        int sIdx=0;
        for(int i=0;i<str.length();i++){

            if(str.charAt(i)=='#'){

                int len = Integer.valueOf(str.substring(sIdx,i));
                i+=1;
                op.add(str.substring(i,i+len));
                
                sIdx=i+len;
                i=i+len-1;
            }
        }

        return op;
    }
}
