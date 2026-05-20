class Solution {
    public String longestCommonPrefix(String[] strs) {
        int idx=0;
        int minLen=Integer.MAX_VALUE;
        StringBuffer sb = new StringBuffer();
        for(String s : strs){

            minLen = Math.min(minLen,s.length());
        }

        while(idx<minLen){
            int len=0;
            char ctm = strs[0].charAt(idx);
            for(String s : strs){
                if(s.charAt(idx)==ctm){
                    len++;
                }
            }

            if(len==strs.length){
                sb.append(ctm);
                idx++;
            }else{
                break;
            }
        }

        return sb.toString();
    }
}