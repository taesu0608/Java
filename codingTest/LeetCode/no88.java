package codingTest.LeetCode;

import java.util.Arrays;

public class no88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        int i = m + n - 1;
        m--;
        n--;

        while (n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[i--] = nums1[m--];
            } else {
                nums1[i--] = nums2[n--];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }
}
