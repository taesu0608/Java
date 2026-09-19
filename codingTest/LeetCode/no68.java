package codingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class no68 {
    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int maxWidth = 16;
        // 문장 구성
        int i = 0;
        int num = 0;
        Queue<Integer> q = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        while(i < words.length){
            num += words[i].length()  + (q.isEmpty() ? 0 : 1);
            q.add(i);
            // 마지막 문장, 왼쪽 정렬로직
            if (i == words.length - 1) {
                while (!q.isEmpty()) {
                    int idx = q.poll();
                    sb.append(words[idx]);

                    // 단어 사이에만 공백 추가
                    if (!q.isEmpty()) {
                        sb.append(' ');
                    }
                }

                // 남은 공간은 오른쪽 공백으로 채움
                sb.append(" ".repeat(maxWidth - sb.length()));
                result.add(sb.toString());
                break;
            }
            if(words[i + 1].length() + 1 + num > maxWidth){
                int ch = q.size() - 1;
                int sp = maxWidth - num + ch;

                int a = ch==0?0:sp/ch;
                int b = ch==0?0:sp%ch;
                while(!q.isEmpty()){
                    int idx = q.poll();
                    //마지막 단어이면+
                    if(q.isEmpty()) {
                        sb.append(words[idx] + " ".repeat(maxWidth-sb.length()-words[idx].length()));
                        break;
                    }
                    if(b-->0){
                        sb.append(words[idx] + " ".repeat(a + 1));
                    } else{
                        sb.append(words[idx] + " ".repeat(a));
                    }
                }
                result.add(sb.toString());
                sb = new StringBuilder();
                num = 0;
            }

            i++;
        }

        System.out.println(result.toString());
    }

}
