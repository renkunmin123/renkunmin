package com.tm.service;

import com.tm.userEntity.User;

import java.util.List;

public interface UserService {
    /**
         * 查询所有用户
         *@Param []
         * @return java.util.List<com.tm.userEntity.User>
         **/
    List<User> getUser();

    /**
         * 新增用户并分配角色
         *@Param [user]
         * @return void
         **/
    void insertUser(User user);

    /**
         * 删除用户
         *@Param [id]
         * @return void
         **/
    void deleteUser(Integer id);

    /**
         * 修改用户
         *@Param [user]
         * @return void
         **/
    void updateUser(User user);
}
