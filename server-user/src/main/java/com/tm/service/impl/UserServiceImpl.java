package com.tm.service.impl;

import com.tm.entity.UserASRole;
import com.tm.mapper.UserMapper;
import com.tm.service.UserService;
import com.tm.userEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUser() {
        List<User> list=userMapper.selectList(null);
        return list;
    }

    @Override
    @Transactional
    public void insertUser(User user) {
        Date date = new Date();
        user.setCreateDate(date);
        userMapper.insert(user);
        List<Integer> roleList = user.getRoleList();
        UserASRole userASRole = new UserASRole();
        userASRole.setUserId(user.getId());
        userASRole.setCreateDate(date);
        for (int i=0;i<roleList.size();i++){
            userASRole.setRoleId(roleList.get(i));
            userMapper.insertUserAsRole(userASRole);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
        userMapper.deleteUserAsRoleById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        Date date = new Date();
        user.setUpdateDate(date);
        userMapper.updateById(user);
        userMapper.deleteUserAsRoleById(user.getId());
        List<Integer> list = user.getRoleList();
        UserASRole userASRole1 = new UserASRole();
        userASRole1.setUserId(user.getId());
        userASRole1.setCreateDate(date);
        for (int i=0;i<list.size();i++){
            userASRole1.setRoleId(list.get(i));
            userMapper.insertUserAsRole(userASRole1);
        }
    }
}
