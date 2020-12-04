package TopInterviewQuestionsEasy.array;


public class singleNumber {
    //异或运算
    public static int singleNumber(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 5, 5, 3, 1};
        System.out.println(singleNumber(nums));
    }
}
