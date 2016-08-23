package cn.ieayoio.spring.spring001_helloworld;

/**
 * Created by ieayoio on 16-8-23.
 */
public class HelloWorld {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Spring 3 : Hello ! " + name);
    }
}
