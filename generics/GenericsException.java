package generics;

import java.util.ArrayList;

public class GenericsException {
    /* 형변환의 종류
        1. upCasting
            subclass -> superclass
            - Java에서 자동형변환()
        2. downCasting
            superclass -> sublcss
            - 명시적 형변환 필요

        boxing
        - boxing이란 Reference type( ex)Wrapper Class)와 primitive type간의 형변환을 일컬음
        1. (Auto)Boxing
            - primitive type -> Wrapper Class 사이에서 발생
        2. (Auto)unBoxing
            - Wrapper Class -> primitive type
            - Exception InvalidCastException

    */
    public static void checkClassCastException() {

        // 1. 초기화시 Generics는 생략 가능 (compiler가 타입 추론)
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<Integer> b = new ArrayList<>();

        // 요소 추가
        a.add("하나");
        a.add("둘");

        b.add(1);
        b.add(2);

        try {
            for (Object o : a)
            {
                o = (Integer)o;
            }
        }catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }
}
