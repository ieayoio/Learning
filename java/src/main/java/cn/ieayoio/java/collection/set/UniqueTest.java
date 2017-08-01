package cn.ieayoio.java.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ieayoio on 2017/8/1.
 */
public class UniqueTest {

    /**
     * Hashset在判断是否重复时，按如下机制进行工作当调用了 HashSet 的 add 方法存放对象 obj ，
     * HashSet 会首先调用 obj 的 hasCode 方法得到该对象的哈希码， HashSet 会使用一个算法把它的哈希码转换成一个数组下标，
     * 该下标“标记”了 obj 的位置。如果这个位置上的链表中没有元素，那么就把 obj 对象添加到链表上。如果这个位置上的链表中已经有了元素，
     * 则遍历这个链表，调用 obj 的 equals 方法，判断 obj 是否和其中的某个元素重复，如果没有重复的元素，那么就将 obj 添加到链表上；
     * 如果有重复的元素，则不会将 obj 对象存入 HashSet 中
     *
     * 参考：http://blog.csdn.net/monkeyduck/article/details/11633061
     *
     * *** 要判断重复需要重写equals和hashCode方法
     *
     * @param args
     */
    public static void main(String[] args) {

        User user1 = new User("张三", 19);
        User user2 = new User("张三", 28);
        User user3 = new User("李四", 29);
        User user4 = new User("张三", 19);

        Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        for (User user : users) {
            System.out.println(user);
        }


    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}