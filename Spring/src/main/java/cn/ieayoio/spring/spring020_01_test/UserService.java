package cn.ieayoio.spring.spring020_01_test;

import java.util.List;

/**
 * Created by ieayoio on 16-9-7.
 */
public interface UserService {

    Integer addUser(User user);

    Integer deleteUser(User user);

    List<User> userlist();

    User getUserbyId(Integer id);
}
