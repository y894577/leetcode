package Algorithms;

import java.util.Dictionary;
import java.util.Stack;

public class t42 {
    public static int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int l = 0;
        int r = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int v = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (leftMax < height[l])
                    leftMax = height[l];
                else
                    v += leftMax - height[l];
                ++l;
            } else {
                if (rightMax < height[r])
                    rightMax = height[r];
                else
                    v += rightMax - height[r];
                --r;
            }
        }
        return v;
    }

    public static int stack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int bottom = 0;
        int total = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                int h = stack.peek();
                stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                total += (Math.min(height[stack.peek()], height[current]) - height[h]) * distance;
            }
            stack.push(current);
            current++;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("trap(height) = " + stack(height));
    }
}
