package codingTest.PastTest;

import com.sun.source.tree.Tree;

public class kakao2025_2 {
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[]{2,2,2};

        int r = 2;
        int l = 1;
        long[] answer = {};
        long purpose = sum1(1,1);

        long length = 0;
        for (int value : arr) {
            length += value;
        }

        //슬라이딩 윈도우 방식
        long left = 0;
        long right = r - l;
        long cur = sum1(left,right);
        long cnt = 0;

        while (right < length) {
            // 현재 구간은 길이가 r - l + 1인 [left, right]
            if (cur == purpose) {
                cnt++;
            }

            // 마지막 구간까지 확인했으므로 종료
            if (right == length - 1) {
                break;
            }

            // 기존 왼쪽 원소 제거
            int leftIdx = (int) left;
            int block = trans(leftIdx, length);
            cur -= arr[block];
            left++;

            // 새로운 오른쪽 원소 추가
            right++;

            int rightIdx = (int) right;
            block = trans(rightIdx, length);
            cur += arr[block];
        }

        System.out.println(purpose+" " +cnt);
    }
    public static int trans(int idx, long length) {
        for (int block = 0; block < arr.length; block++) {
            if (idx < arr[block]) {
                return block;
            }

            idx -= arr[block];
        }
        return 0;
    }
    public static long sum1(long l, long r) {
        // 목표값 구하기
        long idx = 0;
        long result = 0;
        long n_idx;
        for (int i = 0; i < arr.length; i++) {
            // n_idx는 지금 칸의 마지막 항
            n_idx = idx + arr[i] + ((i==0)?-1:0);
            if(n_idx >= l) {

                result += arr[i] * (n_idx - l + 1);
                l = n_idx + 1;
            }
            idx = n_idx;
            if(n_idx > r) {
                result -= arr[i] * (n_idx - r);
                break;
            }
        }
        return result;
    }
}
