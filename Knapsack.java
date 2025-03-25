public class Knapsack {
    // Function to solve 0/1 Knapsack using Bottom-Up Dynamic Programming
    public static int knapsack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];

        // Build DP table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case
                } else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Print the DP table (optional for debugging)
        System.out.println("DP Table:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                System.out.print(dp[i][w] + " ");
            }
            System.out.println();
        }

        return dp[n][W]; // Maximum value for given capacity
    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120}; // Values of items
        int wt[] = {10, 20, 30}; // Weights of items
        int W = 50; // Knapsack capacity
        int n = val.length; // Number of items

        int maxValue = knapsack(W, wt, val, n);
        System.out.println("\nMaximum value achievable: " + maxValue);
    }
}