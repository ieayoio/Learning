package cn.ieayoio.spring.spring017_01_Spring_EL_bean;

/**
 * Created by ieayoio on 16-9-7.
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {

    @Value("#{addressBean}")
    private Address address;

    @Value("#{addressBean.country}")
    private String country;

    @Value("#{addressBean.getFullAddress('哈哈')}")
    private String fullAddress;

    @Override
    public String toString() {
        return "Customer{" +
                "address=" + address +
                ", country='" + country + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}