package lib.Optional;

import java.util.Optional;

public class Optional01 {
    public static String getStr() {
        System.out.println("I am being evaluated");     return "Hi!"; }

    public static void main(String[] args) {
        Optional<String> str = Optional.of("I exist");

        // getSet()은 실행되나 값이 존재하므로 반환값 Hi 할당 X
        String a = str.orElse(getStr());         // getStr() 실행됨

        // 값이 존재하므로 getStr() 실행 X
        String b = str.orElseGet(() -> getStr());  // getStr() 실행안됨
    }
}

