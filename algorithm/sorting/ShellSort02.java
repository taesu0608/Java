package algorithm.sorting;

public class ShellSort02 {
    public static void main(String[] args) {
        int[] input = new int[]{9,1,6,7,3,8,2,4};

        for(int gap = input.length/2 + 1;gap >= 1;){
            for (int i = gap; i < input.length; i++) {
                int temp = input[i];
                int j = i;

                while (j >= gap && input[j - gap] > temp) {
                    input[j] = input[j - gap];
                    j -= gap;
                }

                input[j] = temp;
                }

            //무한반복 방지 종료 조건
            if (gap == 1) {
                break;
            } else if (gap == 2) {
                gap = 1;
            } else {
                gap = gap / 2 + 1;
            }
        }

        for(int i : input){
            System.out.print(i+" ");
        }
    }
}
