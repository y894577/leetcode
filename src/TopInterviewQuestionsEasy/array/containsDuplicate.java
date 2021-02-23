package TopInterviewQuestionsEasy.array;

import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(containsDuplicate(nums));
    }
}
