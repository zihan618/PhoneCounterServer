package com.phonecounter.server.dao;

import com.phonecounter.server.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Mapper
@Repository
public class UserDao {
    String namespace = "user.";

    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public UserDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User login(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        User one = session.selectOne(namespace + "login", user);
        return one;
    }

    public boolean register(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        session.insert(namespace + "register", user);
        return true;
    }
}
