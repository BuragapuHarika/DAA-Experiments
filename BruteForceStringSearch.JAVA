public class BruteForceStringSearch {
    public static boolean bruteForceSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return true; // Pattern found
            }
        }
        return false; // Pattern not found
    }

    public static void main(String[] args) {
        String text = "This is a trial string.";
        String pattern = "rial";

        if (bruteForceSearch(text, pattern)) {
            System.out.println("Pattern '" + pattern + "' found in the string.");
        } else {
            System.out.println("Pattern '" + pattern + "' not found in the string.");
        }
    }
}
