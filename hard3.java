public class CountDigitOne {
    public int countDigitOne(int n) {
        int count = 0;
        long factor = 1; // To handle integer overflow

        while (n / factor > 0) {
            long currentDigit = (n / factor) % 10;
            long before = n / (factor * 10);
            long after = n % factor;

            if (currentDigit == 0) {
                count += before * factor;
            } else if (currentDigit == 1) {
                count += before * factor + after + 1;
            } else {
                count += (before + 1) * factor;
            }

            factor *= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        CountDigitOne solution = new CountDigitOne();
        int n = 13;
        int result = solution.countDigitOne(n);

        // Print the result
        System.out.println(result);
    }
}
