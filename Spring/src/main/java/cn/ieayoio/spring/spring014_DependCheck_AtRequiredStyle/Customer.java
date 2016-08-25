package cn.ieayoio.spring.spring014_DependCheck_AtRequiredStyle;

/**
 * Created by ieayoio on 16-8-25.
 */
public class Customer
{
    private Person person;
    private int type;
    private String action;

    public Person getPerson() {
        return person;
    }

    @Mandatory
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

    @Override
    public String toString() {
        return "Customer{" +
                "person=" + person +
                ", type=" + type +
                ", action='" + action + '\'' +
                '}';
    }
}
