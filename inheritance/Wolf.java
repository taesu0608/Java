package inheritance;

public class Wolf extends Animal{
    Wolf(String name){
        super(name);
    }

    public static void main(String[] args) {
        Wolf wolf = new Wolf("Wolf");
        wolf.cry();
    }
}
