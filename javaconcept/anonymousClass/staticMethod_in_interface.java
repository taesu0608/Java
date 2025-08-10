package javaconcept.anonymousClass;


// 인터페이스에 해당 인터페이스의 익명클래스로 인스턴스를 반환하는 static method를 생성해봦
interface Human {
    void fight();

    static Human born(){
        return new Human() {
            @Override
            public void fight() {
                System.out.println("투쟁");
            }
        };
    }
}
public class staticMethod_in_interface {
    public static void main(String[] args) {
        Human human = Human.born();
        human.fight();
    }
}
