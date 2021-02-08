package Algorithms3;

public class t136 {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(singleNumber(nums));
    }
}
