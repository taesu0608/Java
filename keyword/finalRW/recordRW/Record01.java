package keyword.finalRW.recordRW;

public record Record01(String name, int age) {
    /*
    아래와 같은 코드가 생성됨

    public final class Person{
        private final String name;
        private final int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String name() {return name;}
        public int age() {return age;}

        @Override
    }
    */
}
