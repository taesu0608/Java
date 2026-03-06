package codingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
ISBN

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	19047	7183	6439	37.388%
문제

ISBN(International Standard Book Number)은 전 세계 모든 도서에 부여된 고유번호로,
국제 표준 도서번호이다. ISBN에는 국가명, 발행자 등의 정보가 담겨 있으며 13자리의 숫자로 표시된다.
그중 마지막 숫자는 체크기호로 ISBN의 정확성 여부를 점검할 수 있는 숫자이다.
이 체크기호는 일련번호의 앞에서부터 각 자리마다 가중치 1, 3, 1, 3…. 를 곱한 것을 모두 더하고,
그 값을 10으로 나눈 나머지가 0이 되도록 만드는 숫자 m을 사용한다. 수학적으로는 다음과 같다.

ISBN이 abcdefghijklm 일 때, a+3b+c+3d+e+3f+g+3h+i+3j+k+3l+m ≡ 0 (mod 10)
즉, 체크기호 m = 10 - (a+3b+c+3d+e+3f+g+3h+i+3j+k+3l) mod 10 이다.
단, 10으로 나눈 나머지 값이 0일 경우 체크기호는 0이다.

전북대학교 중앙도서관에서 사서로 일하고 있는 영훈이는 책 정리를 하다가 개구쟁이 광현이에 의해서 ISBN이 훼손된 도서들을 발견했다.
광현이때문에 야근해야 하는 불쌍한 영훈이를 위해서 손상된 자리의 숫자를 찾아내는 프로그램을 작성해주자.

입력
ISBN 13자리 숫자가 입력된다. 훼손된 숫자는 *로 표시한다. (훼손된 일련번호는 체크기호를 제외한 무작위 한 자리이다.)

출력
훼손된 숫자 *에 알맞은 숫자를 출력한다.

예제 입력 1
9788968322*73
97889683222*3
*788968322273
978896*322273
9788968*22273
예제 출력 1
2
*/

public class no14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int sum = 0;
        boolean flag3 = false;
        //m을 제외한 계산
        for(int i = 0; i < 13; i++){
            if(!(s.charAt(i) == '*')){
            int n = s.charAt(i) - '0';
            sum += ((i + 1) % 2 == 0) ? 3 * n : n;
            }else{
                flag3 = (i + 1)%2 == 0? true : false;
            }
        }
        /*
        3
        6
        9
        12
        15
        18
        21
        24
        27
        * */
        if(flag3) {
            switch ((10 - sum%10))
            {
                case 10: System.out.println(0); break;
                case 1: System.out.println(7); break;
                case 2: System.out.println(4); break;
                case 3: System.out.println(1); break;
                case 4: System.out.println(8); break;
                case 5: System.out.println(5); break;
                case 6: System.out.println(2); break;
                case 7: System.out.println(9); break;
                case 8: System.out.println(6); break;
                case 9: System.out.println(3); break;
            }
        }
        else System.out.println(10 - sum%10);
    }
}
