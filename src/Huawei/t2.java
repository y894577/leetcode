package Huawei;


import java.util.Scanner;

public class t2 {
    static class Main {
        public static void main(String[] args) {
            int[] info = new int[1000];
            Scanner scanner = new Scanner(System.in);
            int index = 0;
            int res = Integer.MAX_VALUE;
            String str = scanner.nextLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c < '0' || c > '9')
                    continue;
                info[index] = c - '0';
                if (index != 0) {
                    if (info[index - 1] >= info[index])
                        info[index] = info[index - 1] - info[index];
                    else
                        info[index] = info[index] + index + 1;
                }
                ++index;
            }
            System.out.println(info[index - 1]);
        }
    }
}
