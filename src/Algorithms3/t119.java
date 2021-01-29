package Algorithms3;

import java.util.ArrayList;
import java.util.List;

public class t119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> front = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    list.add(1);
                else {
                    list.add(front.get(j) + front.get(j - 1));
                }
            }
            front = list;
        }
        return front;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }
}
