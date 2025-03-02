package keyword.finalRW;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Final01 {
/*
    1. 멤버 final
        1 - 1. 포인터 방식의 직접 변환 UnsafeClass()
        1 - 2. 필드 fianl 멤버와 로컬 final 멤버
    2. 메서드 final
        - 상속시 override 방지
        - 공통 기능, 메서트 템플릿등 변경 사유가 없는 경우 주로 사용
            cf) 강제로 final 메서드 변경하기
                a. 오버로딩으로 같은명의 메서드
                b. 조합(Composition) 사용
                c. 리플렉션(Reflection) 라이브러리
                d. Proxy를 활용한 객체 탈취
    3. 클래스 final
        - 상속을 금지
    */

    // 필드 fianl
    static final int a = 1;
    public static void main(String[] args) throws Exception{

        // 1 - 1. 포인터와 같이 직접 참조 변환
        Final01 f = new Final01();
        f.UnsafeClass();

        // 1 - 2. 필드 final a, 로컬 final b 둘다 출력
        final int b = 2;
        System.out.println(a + "," + b);

        // 2 - 1. 메서드 Final
        Final02 f2 = new Final02();
        f.finalMethod();
        f2.finalMethod(a);
        f2.compFinalMethod();

        //

    }
    public void UnsafeClass() throws Exception{
        /*
        1 - 1. 주소값을 통한 변환
        주소값을 가져와서 값을 변경해보자
            - JNI(Java Native Interface)를 사용하여 C++로 포인터 사용
            - Unsafe 클래스 사용
        */
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        // 메모리 할당
        long memoryAddress = unsafe.allocateMemory(4L);

        // 메모리에 값 쓰기
        unsafe.putInt(memoryAddress, 42);

        // 메모리에서 값 읽기
        int value = unsafe.getInt(memoryAddress);
        System.out.println("Value at memory address: " + value); // 출력: 42

        // 메모리 해제
        unsafe.freeMemory(memoryAddress);
    }

    final public void finalMethod(){
        System.out.println("this is final method");
    }
}

final class Final02 extends Final01{
    /*
    cf) 강제로 final 메서드 변경하기
    a. 오버로딩으로 같은명의 메서드
    b. 조합(Composition) 사용
    TODO: c. 리플렉션(Reflection) 라이브러리를 활용한 final 회피
    TODO: d. Proxy를 활용한 객체 탈취
    */

    public void finalMethod(int a){
        //a. 오버로딩
        System.out.println("this is overloaded final method");
    }

    public void compFinalMethod(){
        //b. 조합(Composition) 사용
        System.out.println("this is composited final method");
        finalMethod();
    }
}

/* 3. 클래스 final
class Final03 extends Final02(){

        }
*/

