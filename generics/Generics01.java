package generics;

import java.util.ArrayList;
import java.util.List;

public class Generics01 {
    /*geneircs는 runtime시의 ClassCastException을 complietime의 Error로 발생하도록 해준다.
이는 타입 안정성(Type Safety)를 높여준다.*/
    public static void main(String[] args) {

        int number = 10;
        String name = "십";
        List<String> list = new ArrayList<>();
        list.add("리스트");

        GenericsException ge = new GenericsException();
        ge.checkClassCastException();

        // generics.Generics 선언 방법
        // 1. generics.Generics 클래스 Generics.class
        // 2. generics.Generics 메서드 Generics.genericsMethod();
        // 3. 다중 generics.Generics
        // 4. 중첩 generics.Generics
        // 5. 타입 경계
        // 6. 와일드 카드
        
        // cf. Generics는 비교연산자 사용 불가

        //1. Generics의 type 출력
        Generics<String> gd = new Generics<>();
        gd.printInteger(number); //매개변수의 비제네릭스 타입 출력
        gd.printGenerics(name); //매개변수의 재네릭스 타입 출력

        //2. genericsMethod의 type 출력
        gd.printGenericsMethod(list);

        //3. MultiGenerics
        MultiGenerics mg = new MultiGenerics();
        mg.printMultiGenerics(number, name);


        //4. nested(중첩된) Generics의 출력
        Generics<ArrayList<String>> nested = new Generics<>();
        nested.printNestedGenericsMethod(list);

        // 5. 타입 경계
        /*class BoundedTypeGenerics<K extends Number>{
            public void
        }*/

        //6. 와일드 카드
        /*
        class BoundedTypeGenerics <? super generics.A>{

        }
    */

    }
}
