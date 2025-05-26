package algorithm.recursive;

public class Factorial {
    public static void main(String[] args) {
            System.out.println("recursive factorial : " + factorial(5));
            System.out.println("for loop factorial : " + +factorial2(5));
    }

    public static int factorial(int A) {
        int result;
        if (A != 1){
            result = A * factorial(A-1);
            return result;
        }
        else return 1;
    }

    public static int factorial2(int A) {
        // recursive 사용하지 않고 factorial 구현
        int result = 1;
        for (int i = 1; i <= A; i++){
            result = i * result;
        }
        return result;
    }
}
