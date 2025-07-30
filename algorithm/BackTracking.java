package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BackTracking {

    static ArrayList<StringBuilder> arrays = new ArrayList<>();
    static boolean p = true;
    static int N;
    static int K;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        Method(p,1,sb);
        for(StringBuilder array: arrays){
            System.out.println(array);
        }
    }

    public static void Method(boolean person, int wins, StringBuilder result){
        for(int i = 0; i < wins; i++){
            // 가능한 대진표 여부 체킹
            if(person) {count++;}
            else {count--;};

            if(!check()){return;}

            //가능한 경기수 체킹  및  체킹 통과시 결과 기록
            result.append(person ? "R" : "B");
            if(result.length() == N){
                arrays.add(new StringBuilder(result));
                return;
            }
            // 승자 전환
            person = !person;

            // 이전 연승 경우의 수 탐색
            for(int j = 1; j <= wins; j++){
                Method(person,j,result);
            }
        }
    }

    public static boolean check(){
        if(Math.abs(count)< K)return true;
        else return false;
    }
}
