package cn.ieayoio.spring.spring011_SpringDate;

/**
 * Created by ieayoio on 16-8-24.
 */
import java.util.Date;

public class Customer {

    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Customer [date=" + date + "]";
    }

}
