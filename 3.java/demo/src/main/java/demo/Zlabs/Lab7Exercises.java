package demo.Zlabs;

public class Lab7Exercises {
    public void start() {
        int[] numbers = { 1, 3, -5, 7, 0, 4, 6, 8 };

        System.out.println("Task 1: Sum of numbers = " + findSum(numbers));
        System.out.println("Task 2: Average of numbers = " + findAverage(numbers));
        System.out.println("Task 3: Minimum number = " + findMin(numbers));
        System.out.println("Task 4: Maximum number = " + findMax(numbers));
        System.out.println("Task 5: Index of number zero = " + findIndexOfZero(numbers));

        System.out.println("Task 6: Sorted array:");
        sort(numbers);
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    private int findSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    private double findAverage(int[] numbers) {
        int sum = findSum(numbers);
        return (double) sum / numbers.length;
    }

    private int findMin(int[] numbers) {
        int min = numbers[0];
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    private int findMax(int[] numbers) {
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private int findIndexOfZero(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}