package copy;
/*
    1. 얕은 복사
        - 원시 타입 복사
        - 참조 타입 복사 -> 객체의 주소값 복사
    2. 깊은 복사
        - 원시 타입 복사
        - 참조 타입 복사 -> 객체의 원시타입 매개변수 복사
    3. 방어적 복사

*/
public class ShallowCopy {
    static int resource = 10;
    public static void main(String[] args) {

        // 1. 원시 타입 복사
        int copied = resource;
        System.out.println("resource = " + resource);
        System.out.println("copied = " + copied);
        System.out.println("copied sets 15");
        copied = 15;
        System.out.println("resource = " + resource);
        System.out.println("copied = " + copied);

        // 2. (얕은)참조 타입 복사
        SourceClass sc = new SourceClass();
        SourceClass sc2 = sc;
        System.out.println("ressourceClass = %s".formatted(sc.toString()));
        System.out.println("copiedClass = %s".formatted(sc2.toString()));
        // -> result) 두 객체의 주소값이 일치함
    }
}

class SourceClass {
    int a;
}
