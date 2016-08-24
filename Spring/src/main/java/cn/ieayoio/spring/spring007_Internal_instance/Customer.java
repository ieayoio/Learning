package cn.ieayoio.spring.spring007_Internal_instance;

/**
 * Created by ieayoio on 16-8-24.
 */
public class Customer
{
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Customer [person=" + person + "]";
    }
}
