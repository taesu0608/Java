package javaconcept.inheritance;

public class Animal {
    String name;
    Integer age;
    Animal(String name) {
        this.name = name;
        System.out.println("Animal 생성자 name: " + name);
    }
    Animal(String name, int age){
        this(name);
        this.age = age;
    }
    void cry(){
        System.out.println("Animal.cry()" + name + "    "+ age);
    }
                                                                                      }
