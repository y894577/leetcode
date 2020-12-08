package TopInterviewQuestionsEasy.string;

public class isPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (!(chars[left] >= 'a' && chars[left] <= 'z')
                    && !(chars[left] >= 'A' && chars[left] <= 'Z')
                    && !(chars[left] >= '0' && chars[left] <= '9')) {
                ++left;
                continue;
            }

            if (!(chars[right] >= 'a' && chars[right] <= 'z')
                    && !(chars[right] >= 'A' && chars[right] <= 'Z')
                    && !(chars[right] >= '0' && chars[right] <= '9')) {
                --right;
                continue;
            }

            if (chars[left] >= 65 && chars[left] <= 90)
                chars[left] += 32;

            if (chars[right] >= 65 && chars[right] <= 90)
                chars[right] += 32;

            if (chars[left] != chars[right])
                return false;

            ++left;
            --right;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
