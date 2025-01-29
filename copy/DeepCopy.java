package copy;
/*
    1. 얕은 복사
        - 원시 타입 복사
        - 참조 타입 복사 -> 객체의 주소값 복사
    2. 깊은 복사
        - 참조 타입 복사 -> 객체의 원시타입 매개변수 복사
    3. 방어적 복사

*/
public class DeepCopy {
    static int resource = 10;
    public static void main(String[] args) {

        // 1. (깊은)참조 타입 복사
        SourceClass sc = new SourceClass();
        SourceClass sc2 = new SourceClass();
        sc2.a = sc.a;
        System.out.println("ressourceClass = %s".formatted(sc.toString()));
        System.out.println("copiedClass = %s".formatted(sc2.toString()));
        System.out.println(sc.equals(sc2));
        System.out.println(sc2.a == sc.a);
        // -> result) 두 객체의 주소값이 다르지만 파라미터가 같음
    }
}
