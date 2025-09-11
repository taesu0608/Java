package algorithm.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BFSgrid {
    // R, C는 맵의 상지ㅡ
    static int R, C;
    static char[][] map;
    static int[][] dist;
    // 위, 아래, 왼, 오 에 해당하는 증감값
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int bfs(int sr, int sc, int tr, int tc){
        for (int i = 0; i < R; i++) Arrays.fill(dist[i], -1);
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr,sc});
        dist[sr][sc] = 0;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            // 현재 row 와 column
            int r = cur[0], c = cur[1];
            if (r == tr && c == tc) return dist[r][c];

            for (int k = 0; k < 4; k++){
                //현재 r,c의 이동거리 +
                int nr = r + dr[k], nc = c + dc[k];
                // 맵 바깥일 경우
                if (nr < 0|| nr>=R || nc < 0|| nc>=C) continue;
                // #은 벽을 의미
                if (map[nr][nc] == '#') continue;
                // 기탐험된 지역일 경우
                if (dist[nr][nc] != -1) continue;
                // 다음 위치에 현재 위치의 값 대입
                dist[nr][nc] = dist[r][c] + 1;
                // q에 다음 탐색위치 추가
                q.offer(new int[]{nr,nc});
            }
        }
        return -1;
    }
}
