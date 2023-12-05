public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            // Update heights array based on the current row
            for (int j = 0; j < n; j++) {
                heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
            }

            // Calculate the maximum area rectangle ending at each cell
            for (int j = 0; j < n; j++) {
                int minHeight = heights[j];
                for (int k = j; k >= 0 && heights[k] > 0; k--) {
                    minHeight = Math.min(minHeight, heights[k]);
                    int width = j - k + 1;
                    maxArea = Math.max(maxArea, minHeight * width);
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaximalRectangle solution = new MaximalRectangle();
        char[][] matrix = {
                {'0'}
        };
        int result = solution.maximalRectangle(matrix);

        // Print the result
        System.out.println(result);
    }
}
