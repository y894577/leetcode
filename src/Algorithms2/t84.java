package Algorithms2;

import java.util.Stack;

public class t84 {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        //寻找左边界
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()])
                stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        //寻找右边界
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()])
                stack.pop();
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++)
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * heights[i]);

        return maxArea;
    }

    /*
    ！！-------------未完成有bug-------------------！！
    想象成锯木板，如果木板都是递增的那我很开心，如果突然遇到一块木板i矮了一截，
    那我就先找之前最戳出来的一块（其实就是第i-1块），计算一下这个木板单独的面积，
    然后把它锯成次高的，这是因为我之后的计算都再也用不着这块木板本身的高度了。
    再然后如果发觉次高的仍然比现在这个i木板高，那我继续单独计算这个次高木板的面积（应该是第i-1和i-2块），
    再把它俩锯短。直到发觉不需要锯就比第i块矮了，那我继续开开心心往右找更高的。当然为了避免到了最后一直都是递增的，
    所以可以在最后加一块高度为0的木板。
     */
    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] array = new int[n + 1];
        System.arraycopy(heights, 0, array, 0, n);
        array[n] = 0;
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && array[i] < array[stack.peek()]) {
                maxArea = Math.max(maxArea, (i - stack.peek()) * array[stack.peek()]);
                int pop = stack.pop();
                if (stack.isEmpty()) {
                    array[pop] = array[i];
                    stack.push(pop);
                } else {
                    array[pop] = array[stack.peek()];
                }
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
//        int[] nums = {4, 2, 0, 3, 2, 5};
//        int[] nums = {4, 2, 0, 3, 2, 5};
        int[] nums = {4, 2, 0, 3, 2, 5};
        int i = largestRectangleArea2(nums);
        System.out.println(i);
    }
}
