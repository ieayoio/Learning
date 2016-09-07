package cn.ieayoio.spring.spring020_01_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ieayoio on 16-9-7.
 */

@Service("UserServiceImpl1")
public class UserServiceImpl implements UserService {


    @Autowired
    @Qualifier("userdao1")
    private UserDao userDao;

    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Integer deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public List<User> userlist() {
        return userDao.userlist();
    }

    @Override
    public User getUserbyId(Integer id) {
        return userDao.getUserbyId(id);
    }
}
