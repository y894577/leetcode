package Algorithms2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t89 {
    public static List<Integer> grayCode(int n) {
        List<Integer> code = new ArrayList<>();
        boolean[] visit = new boolean[1 << n];
        back(code, visit, n, 0);
        return code;
    }

    public static boolean back(List<Integer> code, boolean[] visit, int n, int currentNum) {
        if (code.size() == (1 << n))
            return true;

        visit[currentNum] = true;
        code.add(currentNum);
        for (int i = 0; i < n; i++) {
            int nextNum = currentNum ^ (1 << i);
            if (!visit[nextNum] && back(code, visit, n, nextNum))
                return true;
        }
        visit[currentNum] = false;
        return false;
    }

    public static void main(String[] args) {
        List<Integer> list = grayCode(2);
        System.out.println(list.toString());
    }
}
