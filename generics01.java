import java.util.List;
import java.util.ArrayList;
/*geneircs는 runtime시의 ClassCastException을 complietime의 Error로 발생하도록 해준다.
이는 타입 안정성(Type Safety)를 높여준다.*/
/*
*
* */

public class generics01 {
    public static void main(String[] args) {

        int a = 10;
        String b = "10";
        List<String> c = new ArrayList<>();

        //genericsTest.checkClassCastException();
        
        //Generics의 type 출력
        genericsDeclaration<String> gd = new genericsDeclaration<>();
        gd.plainMethod(a);
        gd.genericsMethod(b);
        
        //nested(중첩된) Generics의 출력
        genericsDeclaration<ArrayList<String>> nested = new genericsDeclaration<>();
        nested.plainMethod(a);
        nested.genericsMethod(c);
    }

}
class genericsTest{
    //runtime시 ClassCastException 오류 발생 메서드
    public static void checkClassCastException() {

        // 1. 초기화의 Generics는 생략 가능 (compiler가 타입 추론)
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<Integer> b = new ArrayList<>();

        // 요소 추가
        a.add("하나");
        a.add("둘");

        b.add(1);
        b.add(2);

        for (Object o : a)
        {   
            // WrapClass간의 타입변환시 Exception 발생
            /* AutoBoxing, AutoUnBoxing은 primitive type 과 Wrapper Classes 사이에서만 발생
                String -> Integer 는 Wrapper간의 타입 변환이므로 ClassCastiongException 발생
            */
            o = (Integer)o;
        }
    }
}

// Generics 선언 방법 1. Generics 클래스 2. Generics 메서드 3. 다중 Generics 4. 중첩 Generics
// 1. Generics 클래스
class genericsDeclaration<T>{
    public void plainMethod(Integer a){
        System.out.println("plainMethod: "+a.getClass().getName());
    }
    public void genericsMethod(T a){
        System.out.println("genericsMethod: "+a.getClass().getName());
    }
    public static <U> void another_genericsMethod(U a){
        System.out.println("일반클래스 내 Generics 클래스 선언 방식: "+a.getClass().getName());
    }
    // 4. 중첩 Generics
    public void genericsMethod(List<String> a){}
}
// 3. 다중 Generics
class multiGenericsDeclaration<T, U>{
    public void plainMethod(Integer a){
        System.out.println("plainMethod: "+a.getClass().getName());
    }
    // Generics는 method overloading에서 type구분 역할을 하지 못함
    /*
    public void genericsMethod(T a){
        System.out.println("genericsMethod: "+a.getClass().getName());
    }
    public void genericsMethod(U b){
        System.out.println("genericsMethod: "+b.getClass().getName());
    }*/
    public void multiGenericsMethod(T a, U b)
    {
        System.out.println("multiGenericsMethod: "+a.getClass().getName());
        System.out.println("multiGenericsMethod: "+b.getClass().getName());
    }
}

