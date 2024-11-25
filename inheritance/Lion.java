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
        Animal animal = new Animal("Animal");
        //instanceof 메서드 활용
        boolean l1 = lion instanceof Lion;
        boolean l2 = lion instanceof Animal;
        boolean a1 = animal instanceof Lion;
        boolean a2 = animal instanceof Animal;
        System.out.println("Lion? Lion; Animal;" + l1 +" "+l2);
        System.out.println("Animal? Lion; Animal;" + a1 +" "+a2);
    }
}
