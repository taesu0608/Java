package javaconcept.functionalInterface;

@FunctionalInterface
interface CustomInterface<T> {
    T myCall();

    default void printDefault() {
        System.out.println("Hello Default");
    }

    static void printStatic() {
        System.out.println("Hello Static");
    }
}
