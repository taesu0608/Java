package designPattern.proxy;

public class Employee {
    private String name;
    private RESPONSIBILITY position;

    public Employee(String name, RESPONSIBILITY position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public RESPONSIBILITY getGrade(){
        return position;
    }

    public String getInfo(Employee viewer){
        return "Display " + getGrade().name() + " '" + getName() + "' personnel information.";
    }
}
