package cn.ieayoio.spring.spring020_01_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ieayoio on 16-9-7.
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring020_01_test.xml");

        UserService myUserService = (UserService) context.getBean("UserServiceImpl1");

        myUserService.getUserbyId(1111);

        User myuser = (User) context.getBean("myuser");
        myUserService.deleteUser(myuser);

        List<User> userlist = myUserService.userlist();

        myUserService.addUser(myuser);


    }
}