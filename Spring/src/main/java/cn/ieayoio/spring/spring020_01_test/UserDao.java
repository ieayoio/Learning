package cn.ieayoio.spring.spring020_01_test;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ieayoio on 16-9-7.
 */
@Repository("userdao1")
public interface UserDao {

    Integer addUser(User user);

    Integer deleteUser(User user);

    List<User> userlist();

    User getUserbyId(Integer id);
}
