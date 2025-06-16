package javaconcept.functionalInterface;

public class CustomInterfaceTest {
    public static void main(String[] args) {
        // 함수형 인터페이스 구현
        CustomInterface<String> customInterface = () -> "Hello Custom";

        String s = customInterface.myCall();
        System.out.println(s);

        // default method
        customInterface.printDefault();

        // static method
        CustomInterface.printStatic();
    }
}
