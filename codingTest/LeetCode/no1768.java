package codingTest.LeetCode;

public class no1768 {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "def";
        StringBuilder sb =new StringBuilder();
        int cnt = Math.min(word1.length(), word2.length());
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        for(int i = 0; i <cnt*2; i++){
            if(i%2==0) sb.append(a[i/2]);
            else sb.append(b[i/2]);
        }
        String str = word1.length() > word2.length()?word1:word2;
        sb.append(str.substring(cnt));

        sb.toString();
    }
}
