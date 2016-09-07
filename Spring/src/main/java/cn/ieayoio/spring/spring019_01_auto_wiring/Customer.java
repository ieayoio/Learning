package cn.ieayoio.spring.spring019_01_auto_wiring;

/**
 * Created by ieayoio on 16-9-7.
 */
public class Customer {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address=" + address +
                '}';
    }
}
