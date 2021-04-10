package Other;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        scanner.close();
        int left = 0;
        int right = n - 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += w[i];
        }

        System.out.println(dfs(w, left, right, sum));
    }

    public static int dfs(int[] nums, int left, int right, int sum) {
        if (left >= right)
            return 0;
        int leftSum = 0;
        int rightSum = sum;
        int leftMin = 0;
        int rightMin = sum;
        int min = Math.abs(leftSum - rightSum);
        int index = left;
        for (int i = left; i < right; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (Math.abs(leftSum - rightSum) < min) {
                index = i;
                min = Math.abs(leftSum - rightSum);
                leftMin = leftSum;
                rightMin = rightSum;
            }
        }

        if (leftMin < rightMin)
            return leftMin + dfs(nums, left, index, leftMin);
        else
            return rightMin + dfs(nums, index + 1, right, rightMin);
    }
}
