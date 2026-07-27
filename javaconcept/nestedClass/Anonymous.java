package javaconcept.nestedClass;

public class Anonymous {
    public static void main(String[] args) {
        Object o = new Object() {
            void run(){}
        };
        Object o2 = new Object() {
            void run(){}
        };
        Object o3 = new Object() {
            void run(){}
        };
    }
}
