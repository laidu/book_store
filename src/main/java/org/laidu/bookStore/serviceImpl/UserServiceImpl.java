package org.laidu.bookStore.serviceImpl;

import org.laidu.bookStore.mapper.UserMapper;
import org.laidu.bookStore.model.UserModel;
import org.laidu.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by laidu on 16-9-13.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserModel userModel) {
        return userMapper.insertSelective(userModel);
    }

    @Override
    public int delUser(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UserModel findByUsernameAndPassword(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }

    @Override
    public int updateUser(UserModel userModel) {
        return userMapper.updateByPrimaryKeySelective(userModel);
    }
}
