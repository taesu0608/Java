package javaconcept.nestedClass;

public class LocalClass {
    int var = 1000;
    public void Method() {
        class InnerClass {
            String name = "InnerClass";
            int level = 10;

            public void getMethod() {
                System.out.println(level);
                System.out.println(var);
            }
        }
        // (new InnerClass()).getMethod()
        new InnerClass().getMethod();
    }

    public void Method2() {
        class InnerClass { }
        new InnerClass();
    }
    public void main(String[] args) {}
}
