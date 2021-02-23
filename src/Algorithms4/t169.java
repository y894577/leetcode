package Algorithms4;

public class t169 {
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int x : nums) {
            if (count == 0)
                candidate = x;
            if (x == candidate)
                count++;
            else count--;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 5, 8, 8, 9};
        System.out.println("majorityElement(nums) = " + majorityElement(nums));
    }
}
