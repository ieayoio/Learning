package cn.ieayoio.spring.spring019_02_auto_wiring_AtAutowired;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ieayoio on 16-9-7.
 */
public class Customer
{
    @Autowired
    private Person person;

    private int type;
    private String action;

    @Override
    public String toString() {
        return "Customer{" +
                "person=" + person +
                ", type=" + type +
                ", action='" + action + '\'' +
                '}';
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}