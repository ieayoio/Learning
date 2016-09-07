package cn.ieayoio.spring.spring017_03_Spring_EL_ExpressionParser;

/**
 * Created by ieayoio on 16-9-7.
 */
public class Item {

    private String name;

    private int qty;

    public Item(String name, int qty) {
        super();
        this.name = name;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                '}';
    }

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
}
