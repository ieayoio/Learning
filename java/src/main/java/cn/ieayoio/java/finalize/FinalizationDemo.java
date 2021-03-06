package cn.ieayoio.java.finalize;

/**
 * Created by ieayoio on 2017/7/31.
 */
public class FinalizationDemo {
    public static void main(String[] args) {
        Cake c1 = new Cake(1);
        Cake c2 = new Cake(2);
        Cake c3 = new Cake(3);

        c2 = c3 = null;
        // 主动调用垃圾回收，finalize()方法会被调用
        System.gc(); //Invoke the Java garbage collector
    }
}

class Cake {
    private int id;
    public Cake(int id) {
        this.id = id;
        System.out.println("Cake Object " + id + "is created");
    }

    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        System.out.println("Cake Object " + id + "is disposed");
    }
}
