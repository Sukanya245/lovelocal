public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        // Split the string by spaces
        String[] words = s.split(" ");

        // Find the index of the last non-empty word
        int lastIndex = words.length - 1;
        while (lastIndex >= 0 && words[lastIndex].isEmpty()) {
            lastIndex--;
        }

        // Return the length of the last word
        return lastIndex >= 0 ? words[lastIndex].length() : 0;
    }

    public static void main(String[] args) {
        // Example usage
        String input = "Hello World";
        int result = lengthOfLastWord(input);
        System.out.println("Length of the last word: " + result);
    }
}
