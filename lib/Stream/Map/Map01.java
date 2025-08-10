package lib.Stream.Map;

import java.util.*;
import java.util.stream.Collectors;

public class Map01 {
    public static void main(String[] args) {

        // Map을 Collection화 하기 위한 방법
            // map 생성
            Map<Integer, String> map = new HashMap<>();

            // 1. key-value pairs의 set을 구하는 방법
            Set<Map.Entry<Integer, String>> entries = map.entrySet();

            // 2. map의 key set을 구하는 방법
            Set<Integer> keyset = map.keySet();

            // 3. map의 value collection을 구하는 방법
            Collection<String> values = map.values();


        // 예시 값 설정
            map.put(10,"A");
            map.put(11,"A");
            map.put(20,"B");
            map.put(30,"C");
            map.put(40,"D");
            map.put(50,"E");

        // 중간연산자
            // 1. filter() "->" 뒤에는 조건식이 와야함
            System.out.println("1. filter()");
            map.entrySet().stream().filter( entry -> entry.getValue().equals("A")).forEach(System.out::println);
            // 출력: 10=A \n 11=A

            // 2. map()
            System.out.println("2. map()");
            map.values().stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
            // 출력:  랜덤

            // 3. distinct()
            System.out.println("3. distinct()");
            map.values().stream().distinct().forEach(System.out::println);


            // 4. sorted()
            System.out.println("4. sorted()");
            map.values().stream().sorted().forEach(System.out::println);

            // 4.1. sorted(Comparator)
            // Comparator
            System.out.println("4. sorted(Comparator)");
            map.values().stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

            // 5. limit
            System.out.println("5. limit");
            map.values().stream().limit(3).forEach(System.out::println);

            // 6. skip(n)
            System.out.println("6. skip");
            map.values().stream().skip(2).forEach(System.out::println);

            // 7. peek(Consumer)
            System.out.println("7. peek(Consumer)");
            map.values().stream().filter(s -> s.length() > 3)
                    .peek(s -> System.out.println("필터 후: " + s))
                    .map(String::toUpperCase)
                    .peek(s -> System.out.println("대문자 변환 후: " + s))
                    .toList();
    }
}
