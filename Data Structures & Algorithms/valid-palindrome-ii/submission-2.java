class Solution {
    public boolean validPalindrome(String st) {
        int s = 0;
        int e = st.length() - 1;

        while (s < e) {
            if (st.charAt(s) != st.charAt(e)) {
                // Check if the rest of the string is a palindrome
                // IF we skip left OR IF we skip right
                return isPalindrome(st, s + 1, e) || isPalindrome(st, s, e - 1);
            }
            s++;
            e--;
        }

        return true;
    }

    // Just a basic while-loop, no recursion!
    private boolean isPalindrome(String st, int s, int e) {
        while (s < e) {
            if (st.charAt(s) != st.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
}