package com.ycy.mybatis.springmybatisTest;

import com.ycy.mybatis.dao.UserMapper;
import com.ycy.mybatis.module.User;
import javafx.application.Application;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.applet.AppletContext;

/**
 * Created by Administrator on 2015/9/15 0015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class Test11 {

    @Autowired
    private  UserMapper userMapper;
    @Test
    public  void  test111() throws Exception {
        User user=userMapper.getUserById(1);
        System.out.println( user.getUsername());
    }

}
