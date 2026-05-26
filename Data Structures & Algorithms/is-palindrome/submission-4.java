class Solution {
    public boolean isPalindrome(String s) {
        int si=0;
        int ei = s.length()-1;
        while(si<ei){

            while((si<ei) && (!Character.isLetterOrDigit(s.charAt(si)))){
                si++;
            }
            while((ei>si) && (!Character.isLetterOrDigit(s.charAt(ei)))){
                ei--;
            }

            if(si<s.length() && ei>=0 && Character.toLowerCase(s.charAt(si))!=Character.toLowerCase(s.charAt(ei))){
                return false;
            }
            si++;
            ei--;
        }

        return true;

    }
}