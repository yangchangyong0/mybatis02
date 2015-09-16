package com.ycy.mybatis.dao.impl;

import com.ycy.mybatis.dao.UserMapper;
import com.ycy.mybatis.module.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import java.sql.SQLFeatureNotSupportedException;
import java.util.List;

/**
 * Created by Administrator on 2015/8/31 0031.
 */
// 注意需要原始dao方式实现的时候才需要这样 @Service
public class UserMappermpl extends SqlSessionDaoSupport implements UserMapper {

    @Override
    public User getUserById(int id) throws Exception {
        SqlSession sqlSession=this.getSqlSession();
        User user= sqlSession.selectOne("com.ycy.mybatis.dao.UserMapper.getUserById", id);
        return user;
    }
    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession=this.getSqlSession();
        User user= sqlSession.selectOne("test.deleteUser", id);
    }

    @Override
    public void updateUser(User user) throws Exception {
        SqlSession sqlSession=this.getSqlSession();
        sqlSession.selectOne("test.updateUser", user);
    }

    @Override
    public List<User> findUserResultMap(User user) throws Exception {
        SqlSession sqlSession=this.getSqlSession();
        List<User> userList= sqlSession.selectList("com.ycy.mybatis.dao.UserMapper.findUserResultMap", user);
        return userList;
    }



    @Override
    public List<User> findUserByName(String name) throws Exception {
        SqlSession sqlSession=this.getSqlSession();
       List<User> userList= sqlSession.selectList("test.findUserByName", name);
        return userList;
    }

    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSession=this.getSqlSession();
        //2通过sqlsession操作数据库
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
    }
}
