package com.tm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tm.entity.RoleASPermiss;
import com.tm.entity.UserASRole;
import com.tm.roleEntity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<UserASRole> queryUserAsRole(Integer id);

    void insertRoleASPermiss(@Param("permiss") RoleASPermiss roleASPermiss);

    void deleteRoleAsPermiss(Integer id);
}
