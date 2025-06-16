package javaconcept.inheritance.DownCasting;

public class DownCasting {
    /*
    cf) 다운캐스팅시 만약 부모객체와 자손객체의 멤버의 타입,크기가 같다면 런타임 에러가 발생할까?
    IMO) 발생하지 않는다.
        - A) 발생한다.
            - instanceof 예약어(reserved word)를 활용해 Cast확인 이후 DOwnCasting을 진행한다.
    */
    public static void main(String[] args) {
        Human human = new Human();
        Wolf wolf = new Wolf();
        //wolf = (Wolf)human; // ClassCastException 발생

        // cf - A)
        if(wolf instanceof Human){
            System.out.println("Wolf is Human");
        }
    }
}
class Human{}
class Wolf extends Human{ }
