package cn.ieayoio.java.basic;

/**
 * Created by ieayoio on 2017/12/3.
 */
public class MultipleBreak {
    public static void main(String[] args) {

        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i=" + i + ",j=" + j);
                if (j == 5) break ok;
            }
        }


    }
}
