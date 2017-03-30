/**
 * Created by ieayoio on 2016/12/29.
 */
public class Test {

    public static String testException(){

        String d="234";

        try {
            return d.toString();
        } catch (Exception e){
            System.out.println("catch");
            return "return catch";

        }finally {
            System.out.println("finally");

        }

    }

    public static void main(String[] args) {

        String s = testException();

        System.out.println(s);
    }
}
