package inheritance;

public class Lion extends Animal{
    Lion(String name) {
        super(name);
    }
    Lion(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {
        Lion lion = new Lion("Lion");
    }
}
