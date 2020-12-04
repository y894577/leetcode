package TopInterviewQuestionsEasy.array;

import java.util.*;

public class intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums1) map.put(item, map.getOrDefault(item, 0) + 1);
        int[] result = new int[nums1.length];
        int index = 0;
        for (int value : nums2) {
            if (map.containsKey(value)) {
                result[index++] = value;
                int n = map.get(value);
                if (n > 1)
                    map.put(value, n - 1);
                else
                    map.remove(value);
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersect = intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }
}
