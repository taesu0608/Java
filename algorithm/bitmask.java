package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bitmask {
    static final int MON = 1 << 0;
    static final int TUE = 1 << 1;
    static final int WED = 1 << 2;
    static final int THU = 1 << 3;
    static final int FRI = 1 << 4;
    static final int SAT = 1 << 5;
    static final int SUN = 1 << 6;
    public static void main(String[] args) throws IOException {
        // 일주일중 내 근무일을 표시하는 비트마스크를 작성해보자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int input = Integer.parseInt(br.readLine());

        // bit를 직접 생성해 int형을 다루는데 8bit로 다뤄지지 않는다면 채워지지 않는 bit는 무엇으로 채워질까?
        // 아마 최상위 bit부터 0으로 채워질것 같긴하다.
        /*
        * 0b0000001
        * 예상결과 : 1
        *
        * 0b11111111
        * 예상결과 : -1
        * */

        int workDay = 0;

        // if 월 수 금 근무
        workDay |= MON;
        workDay |= WED;
        workDay |= FRI;

        System.out.println(
                Integer.toBinaryString(workDay)
        );

        // 요일별 근무 여부 확인
        // 여기서 0은 0000000을 말하는거겠지?
        boolean isWorking = (workDay & TUE) != 0;
    }
}
