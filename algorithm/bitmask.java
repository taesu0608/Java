package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bitmask {
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
        char[] day = { 0b0000_0001, 0b0000_0010, 0b0000_0100, 0b0000_1000, 0b0001_0000, 0b0010_0000, 0b0100_0000};
        System.out.println(day[0] +" "+ day[1]);
        System.out.println(Integer.toBinaryString(-1));
    }
}
