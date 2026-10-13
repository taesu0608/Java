package codingTest.PastTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class KAKAO_BLIND_RECRUITMENT_2022 {
    static int[] visited;
    static int peaches;
    public static void main(String[] args) {
        int n = 5;
        int[] info = new int[]{2,1,1,1,0,0,0,0,0,0,0};
        visited = new int[4096];

        peaches = 1;
        for (int i = 0; i < info.length; i++) {
            if(info[i] > 0) {
                peaches = (peaches << 1) | 1;
            } else{
                peaches = peaches << 1;
            }
        }

        visited[0b10000000000] = peachesPoint(0b10000000000);

        int result = dfs(info, n, 0, 1);
        System.out.println(Arrays.toString(resultBuilder(result, info, n)));
    }

    // idx: based_0;
    // node: based_0
    public static int dfs(int[] info, int n, int idx, int node) {
        // 남은 칸을 모두 포기해서 최종 배치로 완성
        // 1. 화살이 없는 경우 2. 남은 칸이 없는 경우
        if (n == 0 || idx >= info.length) {
            int fullNode = allOut(node, info, idx);

            visited[fullNode] =
                    rionesPoint(fullNode) - peachesPoint(fullNode);

            return fullNode;
        }

        // 현재 칸 포기
        System.out.println(idx);
        int B = dfs(info, n, idx + 1, node << 1);

        int need = info[idx] + 1;

        // 현재 칸을 가져갈 화살이 부족하면 포기 분기만 가능
        if (n < need) {
            return B;
        }

        // 현재 칸 득점
        int A = dfs(info, n - need, idx + 1, (node << 1) | 1);

        // 더 높은 점수 차를 만드는 최종 배치 반환
        return visited[A] > visited[B] ? A : B;
    }
    // node: 시작 비트 1 + 지금까지의 경기 결과
    // idx: 다음에 처리할 경기 인덱스
    public static int allOut(int node, int[] info, int idx) {
        int rest = info.length - idx;

        return node << rest;
    }
    public static int peachesPoint(int node){
        int point = 0;
        int winPeaches = (peaches & ~node) | Integer.highestOneBit(peaches);

        for(int i = 0; i < 11; i++){
            if(winPeaches % 2 == 1){
                point += i;
                winPeaches = winPeaches >> 1;
            } else {
                winPeaches = winPeaches >> 1;
            }
        }

        return point;
    }
    public static int rionesPoint(int node){
        int point = 0;
        int winRion = node;
        for(int i = 0; i < 11; i++){
            if(winRion%2 == 1){
                point += i;
                winRion = winRion >> 1;
            } else {
                winRion = winRion >> 1;
            }
        }
        return point;
    }
    public static int[] resultBuilder(int node,int[] info, int n) {
        int temp = node;
        int cnt = 0;
        int[] result = new int[11];
        for(int i = 0; i < 11; i++){
            if(temp%2 == 1){
                result[10-i] = info[10-i] + 1;
                cnt += info[10-i] + 1;
                temp = temp >> 1;
            } else {
                temp = temp >> 1;
            }
        }
        if(cnt < n) {
            result[10] += n-cnt;
        }
        return result;
    }
}
