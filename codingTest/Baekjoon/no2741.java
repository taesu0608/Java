package codingTest.Baekjoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/*자연수 N이 주어졌을 때,
1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.*/
public class no2741 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // br.close
        br.close();
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
    public static void other1() throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        int i = 1;
        while(i<=n){
            sb.append(i+'\n');
            i++;
        }
        System.out.println(sb);
    }

}
