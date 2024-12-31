package Sorting;

public class BubbleSort {
    //배열을 뒷부분부터 채우기
    void bubblesort(int[] arr) {

        // 입력된 배열의 크기 = n
        // 배열의 마지막 index = n - 1;
        // 아직 length와 size
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // 배열의 마지막 - 1 부터 i + 1 까지 step 1만큼 감소하며 반복
            for (int j = n - 1; j > i; j--) {
                // j와 j - 1을 비교 및 교환
                if(arr[j - 1] > arr[j])
                    swap(arr, j - 1, j);
            }
        }
    }
    // 배열을 앞부분부터 채우기
    void bubblesort2(int[] arr) {

        // 입력된 배열의 크기 = n
        // 0에서 부터 배열의 끝 - 1 까지
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // j와 j + 1을 비교 및 교환
            for (int j = 0; j <= i; j++) {
                if(arr[j + 1] < arr[j])
                {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    private void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    void printArray(int[] arr){
        for (int i: arr)
        {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] arr = {2,3,4,6,1,34,45,25,11,11};
        bs.bubblesort(arr);
        System.out.println("=======arr=======");
        bs.printArray(arr);

        BubbleSort bs2 = new BubbleSort();
        int[] arr2 = {2,3,4,6,1,34,45,25,11,14};
        bs2.bubblesort2(arr2);
        System.out.println("=======arr2=======");
        bs2.printArray(arr2);
    }
}
