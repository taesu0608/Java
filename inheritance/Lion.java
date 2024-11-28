package inheritance;

public class Lion extends Animal implements Being{

    Lion(String name) {
        super(name);
    }
    Lion(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {
        Lion lion = new Lion("Lion");
        Animal animal = new Animal("Animal");
        // 부모클래스, 자식클래스 간의 instanceof 값 확인
        boolean l1 = lion instanceof Lion;
        boolean l2 = lion instanceof Animal;
        // 부모클래스, 자식클래스 간의 instanceof 값 확인
        boolean a1 = animal instanceof Lion;
        boolean a2 = animal instanceof Animal;
        // interface의 instanceof 값 확인
        boolean i1 = lion instanceof Being;
        boolean i2 = animal instanceof Being;
        // 조부모 클래스의 instanceof 값 확인
        boolean o1 = lion instanceof Object;
        boolean o2 = animal instanceof Object;

        System.out.println("lion? Lion; Animal; " + l1 +" "+l2);
        System.out.println("animal? Lion; Animal; " + a1 +" "+a2);
        System.out.println("lion? (Interface) Being; " + i1);
        System.out.println("animal? (Interface) Being; " + i2);
        System.out.println("lion? (Interface) Object; " + o1);
        System.out.println("animal? (Interface) Object; " + o2);

    }
}
