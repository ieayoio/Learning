package cn.ieayoio.spring.spring019_01_auto_wiring;

/**
 * Created by ieayoio on 16-9-7.
 */
public class Address {
    private String fulladdress;

    public String getFulladdress() {
        return fulladdress;
    }

    public void setFulladdress(String fulladdress) {
        this.fulladdress = fulladdress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "fulladdress='" + fulladdress + '\'' +
                '}';
    }
}
