package javaconcept;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;

public class literal {
    public static void main(String[] args) throws Exception {
        String a = "abc";
        String b = new String("abc");

        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);

        Object aValue = field.get(a);
        Object bValue = field.get(b);

        System.out.println("String 객체 동일: " + (a == b));
        System.out.println("value 배열 동일: " + (aValue == bValue));

        System.out.printf("a.value 식별 해시: %x%n",
                System.identityHashCode(aValue));
        System.out.printf("b.value 식별 해시: %x%n",
                System.identityHashCode(bValue));

    }
}
