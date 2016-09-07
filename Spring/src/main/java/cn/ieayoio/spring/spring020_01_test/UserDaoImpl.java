package cn.ieayoio.spring.spring020_01_test;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ieayoio on 16-9-7.
 */

@Repository("userdao1")
public class UserDaoImpl implements UserDao {
    @Override
    public Integer addUser(User user) {
        System.out.println("add user :" + user);
        return user.getId();
    }

    @Override
    public Integer deleteUser(User user) {

        System.out.println("delete user :" + user);
        return user.getId();
    }

    @Override
    public List<User> userlist() {

        List<User> users = new ArrayList<>();

        User user = new User();
        user.setId(23123);
        user.setName("我叫获取列表");
        user.setAge(23333);

        users.add(user);
        System.out.println("getUserlist:" + users);
        return users;
    }

    @Override
    public User getUserbyId(Integer id) {

        User user = new User();
        user.setId(id);
        user.setName("我叫通过id获取用户");
        user.setAge(23333);

        System.out.println("getUserbyId:" + user);
        return user;
    }
}
