package Algorithms;

import javax.sound.midi.Soundbank;

public class t58 {
    public static int lengthOfLastWord(String s) {
        int length = 0;
        while (s.length() != 0 && s.charAt(s.length() - 1) == ' ')
            s = s.substring(0, s.length() - 1);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                break;
            else
                ++length;
        }
        return length;
    }

    public static void main(String[] args) {
        String s = " ";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }
}
