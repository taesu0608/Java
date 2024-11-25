package inheritance;

public class Wolf extends Animal{
    Wolf(String name){
        super(name);
    }

    Wolf(String name, int age){
        super(name, age);
    }
    public static void main(String[] args) {
        Wolf wolf = new Wolf("Wolf", 13);
        wolf.cry();
        Wolf wolf2 = new Wolf("Wolf2");
        //integer age는 초기화되지 않았기 때문에 null을 반환
        wolf2.cry();
    }
}
