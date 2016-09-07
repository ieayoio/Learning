package cn.ieayoio.spring.spring016_01_Spring_EL_helloWorld;

/**
 * Created by ieayoio on 16-9-7.
 */
public class Customer {

    private Item item;

    private String itemName;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "item=" + item +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}