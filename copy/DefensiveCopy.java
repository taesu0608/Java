package copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
방어적 복사 경우
전제) 원본 파라미터s < 원본 객체 < 반환 객체
- 생성시 방어적 복사 적용
    - 원본 파라미터와의 분리
- 요청시 방어적 복사 적용
    - 원본 객체와의 분리
1. 단일 가변 객체
    - copied 메서드를 방어적 복사로 작성하는 것
    - 매개변수를 입력 받는 생성자를 통해 새로운 객체를 생성하고 반환하는 방법
    - 생성시 원시타입을 통한 객체를 생성하기 때문에 생성시 방어적 복사 적용이 무의미함 (원시타입은 대입이 곧 DeepCopy에 해당하기 떄문)
2. 참조 멤버를 가지는 객체
    - 컬랙션 객체를 새로 생성하여 반환하는 방법
3. 컬렉션 객체
    - 컬랙션 라이브러리의  Collections.unmodifiableList() 메서드를 활용한 방법
        - COllections.unmodifiableList()
            - 방어적 복사로 독립적인 객체 제공 방식이 아닌 객체 수정불가방식의 접근제어방법
            - 불변성 보장
                - add()호출시 UnsupportedOperationException 예외 발생
            - 리스트 전체를 새로이 복사하지 않고 랩핑하는 방식의 처리
            - 원본 리스트에 의존하여 자동 업데이트
*/
public class DefensiveCopy {
    public static void main(String[] args) {
        OuterClass o1 = new OuterClass(10);
        OuterClass o2 = o1.copy();

        o1.showInfo(); // Value: 10
        o2.showInfo(); // Value: 10

        // 3. 컬랙션 객체 Collections.unmodifiableList()
        List<String> mutableList = new ArrayList<>(Arrays.asList("A","B","C"));
        List<String> immutableList = Collections.unmodifiableList(mutableList);

        //요소 추가 시도(UnsupportedOperationException 발생)
    }
}

// 1. 단일 가변객체
class OuterClass {
    private final int a; // 불변성 유지

    OuterClass(int a) {
        this.a = a;
    }

    // 방어적 복사 메서드 (더 간결한 구조)
    public OuterClass copy() {
        return new OuterClass(this.a);
    }

    public int getA() {
        return a;
    }

    public void showInfo() {
        System.out.println("Value: " + a);
    }
}
// 2. 참조 객체
class OuterClass2 {
    private InnerClass i;

    // 생성시 방어적 복사 적용
    public OuterClass2(InnerClass i) {
        this.i = new InnerClass(i.getName());
    }

    // 요청시 방어적 복사 적용
   public InnerClass getInnerClass() {
        return new InnerClass(i.getName());
   }
}
class InnerClass {
    private final String name;
    InnerClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}




