package CodingInterview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class offer38 {
    static class Solution {
        char[] arr;

        public String[] permutation(String s) {
            if (s.isEmpty())
                return new String[]{""};
            this.arr = s.toCharArray();
            List<String> result = new ArrayList<>();
            back(result, 0);
            return result.toArray(new String[result.size()]);
        }

        public void back(List<String> result, int index) {
            if (index == arr.length - 1)
                result.add(String.valueOf(arr));

            HashSet<Character> set = new HashSet<>();
            for (int i = index; i < arr.length; i++) {
                if (set.contains(arr[i])) continue;
                set.add(arr[i]);
                swap(i, index);
                back(result, index + 1);
                swap(i, index);
            }
        }

        public void swap(int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            String[] s = solution.permutation("abcc");
            for (String s1 : s) {
                System.out.println(s1);
            }
        }
    }
}
