package algorithm.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유클리드호제법 {
    public static void main(String[] args) throws IOException {

        System.out.println("최대공약수를 구할 두가지 수를 고르세요");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sr = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(sr.nextToken());
        int y = Integer.parseInt(sr.nextToken());

        System.out.println("using recursive 유클리드 호제법 : " + mutual_division(x,y));
        System.out.println("not using recursive 유클리드 호제법 : " + mutual_division2(x, y));
    }

    public static int mutual_division(int x, int y) {

        if(y!=0)
        {
            return mutual_division(y, x%y);
        }
        else return x;
    }

    public static int mutual_division2(int x, int y) {
        int bigger = (x>y)?x:y;
        int smaller = (x>y)?y:x;
        int modulo = smaller;
        while(modulo != 0)
        {
            modulo = bigger % smaller;
            bigger = smaller;
            smaller = modulo;
        }
        return bigger;
    }
}
