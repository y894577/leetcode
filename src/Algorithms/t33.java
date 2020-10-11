package Algorithms;

public class t33 {
    public static int search(int[] nums, int target) {
        if (nums.length == 1)
            if (target == nums[0])
                return 0;
            else
                return -1;

        //自己的思路：找到旋转点然后二分查找
        //不过此举有些多此一举，可直接二分查找提高速度
        int point = findPoint(nums);

            //官方题解：
//          如果中间的数小于最右边的数，则右半段是有序的
//          若中间数大于最右边数，则左半段是有序的
//          我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了

//        int n = nums.length;
//        int l = 0, r = n - 1;
//        while (l <= r) {
//            int mid = (l + r) / 2;
//            if (nums[mid] == target) return mid;
//            if (nums[0] <= nums[mid]) {
//                if (nums[0] <= target && target < nums[mid]) {
//                    r = mid - 1;
//                } else {
//                    l = mid + 1;
//                }
//            } else {
//                if (nums[mid] < target && target <= nums[n - 1]) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            }
//        }
//        return -1;


        if (nums[0] == target)
            return 0;
        if (point == 0)
            return binarySearch(nums, 0, nums.length - 1, target);
        if (nums[0] < target)
            return binarySearch(nums, 0, point - 1, target);
        else
            return binarySearch(nums, point, nums.length - 1, target);
    }

    public static int findPoint(int[] nums) {
        int i = nums.length - 1;
        while (i >= 1) {
            if (nums[i - 1] > nums[i])
                break;
            else
                --i;
        }
        return Math.max(i, 0);
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        if (end == start || end - start == 1) {
            if (nums[start] == target)
                return start;
            if (nums[end] == target)
                return end;
            return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target)
            return binarySearch(nums, start, mid, target);
        else
            return binarySearch(nums, mid, end, target);
    }

    public static void main(String[] args) {
        int[] nums = {3,5,1};
        int search = search(nums, 0);
        System.out.println(search);
    }
}
