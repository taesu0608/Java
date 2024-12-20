package inheritance.DownCasting;
/*다운캐스팅시 만약 부모객체와 자손객체의 멤버의 타입,크기가 같다면 런타임 에러가 발생할까?
IMO) 발생하지 않는다.*/
public class DownCasting {

    public static void main(String[] args) {
        Human human = new Human();
        Wolf wolf = new Wolf();
        wolf = (Wolf)human; // ClassCastException 발생
    }
}
class Human{}
class Wolf extends Human{ }
