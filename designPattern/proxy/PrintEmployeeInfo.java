package designPattern.proxy;

import java.util.List;

public class PrintEmployeeInfo {
    Employee viewer;

    PrintEmployeeInfo(Employee employee) {
        this.viewer = viewer;
    }

    void printAllinfo(List<Employee> employees){
        employees.stream()
                .map(employee -> employee.getInfo(viewer))
                .forEach(System.out::println);
    }
}