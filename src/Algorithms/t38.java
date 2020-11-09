package Algorithms;

import java.util.Arrays;

public class t38 {
    public static String countAndSay(int n) {
        String[] arr = new String[n + 1];
        arr[0] = "1";
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            String temp = arr[i];
            int front = 0;
            int rear = 1;
            for (int j = 0; j <= temp.length() && rear <= temp.length(); j++) {
                if (rear < temp.length() && temp.charAt(front) == temp.charAt(rear)) {
                    ++rear;
                } else {
                    if (j == temp.length())
                        rear = j;
                    str.append(rear - front );
                    str.append(temp.charAt(rear - 1));
                    front = rear;
                    rear++;
                }
            }
            arr[i + 1] = str.toString();
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(7));
    }
}
