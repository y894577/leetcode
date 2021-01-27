package Algorithms3;

import java.util.ArrayList;
import java.util.List;

public class t118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    list.add(1);
                else {
                    List<Integer> front = result.get(i - 1);
                    list.add(front.get(j) + front.get(j + 1));
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
}
