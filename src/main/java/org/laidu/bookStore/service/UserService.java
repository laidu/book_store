package org.laidu.bookStore.service;

import org.laidu.bookStore.model.UserModel;

/**
 * Created by laidu on 16-9-12.
 */
public interface UserService {
    int addUser(UserModel userModel);
    int delUser(int id);
    UserModel findByUsernameAndPassword(String username, String password);
    int updateUser(UserModel userModel);
}
