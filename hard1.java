import java.util.PriorityQueue;

public class TopKElements {
    public int[] findTopKElements(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        // Create a max heap to store the top-k elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // Add elements to the max heap
        for (int num : nums) {
            maxHeap.offer(num);
        }

        // Retrieve the top-k elements from the max heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKElements solution = new TopKElements();
        int[] nums = {1};
        int k = 1;
        int[] result = solution.findTopKElements(nums, k);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
