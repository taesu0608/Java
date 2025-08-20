package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
단어의 개수
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	469627	156445	125446	33.548%
문제
영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.
단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.

입력
첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다.
단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열은 공백으로 시작하거나 끝날 수 있다.

출력
첫째 줄에 단어의 개수를 출력한다.

예제 입력 1
The Curious Case of Benjamin Button
예제 출력 1
6
예제 입력 2
 The first character is a blank
예제 출력 2
6
예제 입력 3
The last character is a blank
예제 출력 3
6
*/
public class no1152 {
    public static void another(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(st.countTokens());
    }
    public static void another2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            //공백시 반응
            if(input.charAt(i)==' ') {
                // 첫 공백 제외
                if(i==0){continue;}
                // 막 공백 제외
                if(i==input.length()-1){break;}
                count++;
            }
        }


        if (input.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(input.split(" ").length);
        }
    }
    public static void main(String[] args) throws IOException {
        //마지막 입력시 lncf를 활용한 로직 처리
        int count = 0;
        int pre_str = 32; // 공백을 의미
        int str;

        while (true){
            str = System.in.read();

            // 입력받은 문자가 공백일 때,
            if(str == 32){
                if(pre_str != 32){count++;}
            }

            else if(str == 10){ //lf가 왔을 때,
                if(pre_str != 32){count++;}
                break;
            }

            pre_str = str;
        }

        System.out.println(count);
    }
}
