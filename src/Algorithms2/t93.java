package Algorithms2;


import java.util.ArrayList;
import java.util.List;

public class t93 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int length = s.length();
        if (length < 4 || length > 12)
            return result;
        String[] combine = new String[4];
        back(result, s, combine, 0, 0);
        return result;
    }

    public static void back(List<String> result, String s, String[] combine, int depth, int index) {
        if (depth == 4) {
            StringBuffer buffer = new StringBuffer();
            for (String str : combine) {
                buffer.append(str);
                buffer.append(".");
            }
            String ip = buffer.toString().substring(0, buffer.length() - 1);
            if (ip.length() == s.length() + 3)
                result.add(ip);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            if (index + i > s.length())
                break;
            String sub = s.substring(index, index + i);
            if (identify(sub)) {
                combine[depth] = sub;
                back(result, s, combine, depth + 1, index + i);
            }
        }
    }

    public static boolean identify(String str) {
        if (str.length() > 3)
            return false;
        if (str.length() > 1 && str.charAt(0) == '0')
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > '9' && str.charAt(i) < '0')
                return false;
        }
        if (Integer.parseInt(str) > 255)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "0000";
        List<String> list = restoreIpAddresses(s);
        System.out.println(list.toString());
    }

}
