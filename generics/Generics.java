package generics;

import java.util.List;

// 1. generics.Generics 클래스
class Generics<T>{
    public void printInteger(Integer a) {
        System.out.println("plainMethod: " + a.getClass().getName());
    }

    public void printGenerics(T a) {
        System.out.println("PlaingMethod: " + a.getClass().getName());
    }

    //2. generics.Generics 메서드
    public static <U> void printGenericsMethod(U a) {
        System.out.println("genericsMethod: " + a.getClass().getName());
    }

    // 4. 중첩 generics.Generics
    public <U> void printNestedGenericsMethod(List<U> a) {
        System.out.println("nestedGenericsMethod: " + a.get(0).getClass().getName());
    }
}
