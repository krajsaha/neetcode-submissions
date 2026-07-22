class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();

        int f=0;
        int l=0;
        while(f<word1.length() && l<word2.length()){
            sb.append(word1.charAt(f));
            sb.append(word2.charAt(l));
            f++;
            l++;
        }

        while(f<word1.length()){
            sb.append(word1.charAt(f));
            f++;
        }
        while(l<word2.length()){
            sb.append(word2.charAt(l));
            l++;
        }

        return sb.toString();
    }
}