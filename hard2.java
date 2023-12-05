public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        // Combine the string with its reverse, separated by a special character
        String combined = s + "#" + new StringBuilder(s).reverse().toString();

        // Compute the KMP (Knuth-Morris-Pratt) table
        int[] kmpTable = computeKMPTable(combined);

        // Find the length of the longest palindrome prefix
        int longestPalindromePrefixLength = kmpTable[kmpTable.length - 1];

        // Build the shortest palindrome by adding characters in front of the original string
        String prefix = new StringBuilder(s.substring(longestPalindromePrefixLength)).reverse().toString();
        return prefix + s;
    }

    private int[] computeKMPTable(String pattern) {
        int[] kmpTable = new int[pattern.length()];
        int j = 0;

        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                kmpTable[i] = ++j;
            } else {
                if (j > 0) {
                    j = kmpTable[j - 1];
                    i--; // Stay at the current index and compare again
                } else {
                    kmpTable[i] = 0;
                }
            }
        }

        return kmpTable;
    }

    public static void main(String[] args) {
        ShortestPalindrome solution = new ShortestPalindrome();
        String s = "aacecaaa";
        String result = solution.shortestPalindrome(s);

        // Print the result
        System.out.println(result);
    }
}
