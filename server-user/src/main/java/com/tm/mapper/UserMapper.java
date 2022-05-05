package com.tm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tm.entity.UserASRole;
import com.tm.userEntity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper extends BaseMapper<User> {
    void insertUserAsRole(@Param("user") UserASRole userASRole);

    void deleteUserAsRoleById(Integer id);
}
