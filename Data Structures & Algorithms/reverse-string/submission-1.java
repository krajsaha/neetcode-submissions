class Solution {
    void swap(int si,int ei,char[] s){
        char t = s[si];
        s[si] = s[ei];
        s[ei]=t;

    }
    public void reverseString(char[] s) {
        
        int si=0;
        int ei=s.length-1;

        while(si<ei){

            swap(si,ei,s);
            si++;
            ei--;
        }
    }
}