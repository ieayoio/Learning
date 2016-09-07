package cn.ieayoio.spring.spring016_01_Spring_EL_helloWorld;

/**
 * Created by ieayoio on 16-9-7.
 */
public class Item {

    private String name;

    private int qty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                '}';
    }
}