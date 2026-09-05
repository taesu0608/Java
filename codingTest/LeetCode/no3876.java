package codingTest.LeetCode;

public class no3876 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,4,3,9};
        int[] nums2 = new int[nums1.length];
        boolean even_setting = true;
        int min = Integer.MAX_VALUE;

        // 짝 홀 세팅, 최소 홀 찾기
        for (int i = 0; i < nums1.length; i++) {
            if(!isEven(nums1[i])) {
                even_setting = false;
                min = Math.min(min, nums1[i]);
            }
        }

        if(even_setting) {return;}
        for (int i = 0; i < nums2.length; i++) {
            if(isEven(nums1[i])) {
                int gap = nums1[i] - min;
                if(gap >= 1){
                    nums2[i] = gap;
                } else {
                    return;
                }
            }
        }
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
