import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);  // The first and last elements in each row are always 1.
                } else {
                    // The other elements are the sum of the two numbers directly above them.
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();
        int numRows = 5;
        List<List<Integer>> result = solution.generate(numRows);

        // Print the result
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
