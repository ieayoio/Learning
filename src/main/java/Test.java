import java.util.ArrayList;
import java.util.List;

/**
 * Created by ieayoio on 2016/12/29.
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("er");
        list.add("fdf");

        list.forEach(System.out::println);

    }
}
