package cn.ieayoio.spring.spring016_02_Spring_EL_helloWorld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ieayoio on 16-9-7.
 */
@Component("itemBean")
public class Item {

    @Value("itemA") //inject String directly
    private String name;

    @Value("10") //inject interger directly
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