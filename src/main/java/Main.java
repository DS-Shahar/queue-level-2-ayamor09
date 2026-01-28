
import java.util.LinkedList;
import java.util.Queue;

public class QueueExercises {

    // 1. Count lengths of consecutive character runs
    public static Queue<Integer> countRuns(Queue<Character> q) {
        Queue<Integer> result = new LinkedList<>();
        if (q.isEmpty()) return result;

        char current = q.poll();
        int count = 1;

        while (!q.isEmpty()) {
            char c = q.poll();
            if (c == current) {
                count++;
            } else {
                result.add(count);
                current = c;
                count = 1;
            }
        }
        result.add(count);
        return result;
    }

    // 2. Merge two sorted queues
    public static Queue<Integer> mergeSortedQueues(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> result = new LinkedList<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) {
                result.add(q1.poll());
            } else {
                result.add(q2.poll());
            }
        }

        while (!q1.isEmpty()) {
            result.add(q1.poll());
        }

        while (!q2.isEmpty()) {
            result.add(q2.poll());
        }

        return result;
    }

    // 3. Sum of the longest consecutive even sequence
    public static int longestEvenSequenceSum(Queue<Integer> q) {
        int maxLength = 0, maxSum = 0;
        int currentLength = 0, currentSum = 0;

        while (!q.isEmpty()) {
            int num = q.poll();
            if (num % 2 == 0) {
                currentLength++;
                currentSum += num;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxSum = currentSum;
                }
                currentLength = 0;
                currentSum = 0;
            }
        }

        // Final check
        if (currentLength > maxLength) {
            maxSum = currentSum;
        }

        return maxSum;
    }

    // MAIN
    public static void main(String[] args) {

        // Test 1
        Queue<Character> chars = new LinkedList<>();
        chars.add('c');
        chars.add('c');
        chars.add('a');
        chars.add('c');
        System.out.println(countRuns(chars)); // [2, 1, 1]

        // Test 2
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(3);
        q1.add(5);

        Queue<Integer> q2 = new LinkedList<>();
        q2.add(2);
        q2.add(4);
        q2.add(6);

        System.out.println(mergeSortedQueues(q1, q2)); // [1,2,3,4,5,6]

        // Test 3
        Queue<Integer> nums = new LinkedList<>();
        nums.add(2);
        nums.add(4);
        nums.add(1);
        nums.add(6);
        nums.add(8);
        nums.add(10);
        nums.add(3);

        System.out.println(longestEvenSequenceSum(nums)); // 24
    }
}