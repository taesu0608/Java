package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1074 {
    static int r;
    static int c;
    static int cnt;
    public static void another(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cnt = 0;

        int sqrtN = (int) Math.pow(2,n);
        search(0,sqrtN,0,sqrtN);
    }
    public static void search(int xs, int xe, int ys, int ye){
        int gap = (xe - xs)/2;
        if(gap == 0){

            if(xs == c && ys == r){
                System.out.println(cnt);
                return;
            }
            cnt++;
            return;
        }

        search(xs, xs + gap, ys, ys + gap);
        search(xs + gap, xe, ys, ys + gap);
        search(xs, xs + gap, ys + gap, ye);
        search(xs + gap, xe, ys + gap, ye);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int n2 = (int) Math.pow(2,n);
        int idx = n2/2;
        int idy = n2/2;
        int answer  = 0;
        while(n-- > 0){
            int sector = (n2 / 2) * (n2 / 2);
            n2 /= 2;
            if(c < idx && r < idy){
                //제 1사분면
                idx = idx - n2/2;
                idy = idy - n2/2;
            } else if(c >= idx && r < idy){
                //제 2사분면
                answer  += sector;
                idx = idx + n2/2;
                idy = idy - n2/2;
            } else if(c < idx){
                //제 3사분면
                answer  += 2*sector;
                idx = idx - n2/2;
                idy = idy +  n2/2;
            } else{
                //제 4사분면
                answer  += 3*sector;
                idx = idx + n2/2;
                idy = idy + n2/2;
            }

        }
        System.out.println(answer );
    }
}
