
package Algorithms;

public class t11 {
    public static int maxArea(int[] height) {
        int width = 1;
        int site1 = 0;
        int site2 = height.length - 1;
        int volumn = 0;

        while (site1 < site2) {
            width = site2 - site1;
            int h = Math.min(height[site1], height[site2]);
            volumn = Math.max(h * width, volumn);
            if (height[site1] < height[site2]) {
                site1++;
            } else {
                site2--;
            }
        }
        return volumn;
    }

    public static void main(String[] args) {
        int[] height = {1, 15,1};
        int i = maxArea(height);
        System.out.println(i);
    }
}