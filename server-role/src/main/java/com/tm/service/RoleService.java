package com.tm.service;

import com.tm.entity.UserASRole;
import com.tm.roleEntity.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询所有角色
     *@Param []
     * @return com.tm.utils.Result
     **/
    List<Role> getRole();

    /**
         * 使用角色id查询用户
         *@Param [id]
         * @return java.util.List<com.tm.entity.UserASRole>
         **/
    List<UserASRole> queryUserAsRole(Integer id);

    /**
         * 删除角色
         *@Param [id]
         * @return void
         **/
    void deleteRole(Integer id);
    /**
     * 新增角色并赋予权限
     *@Param [id]
     * @return void
     **/
    void insertRole(Role role);


    /**
         * 删除权限集合
         *@Param [permissList]
         * @return void
         **/
    void deleteAllPermissList(Integer id);

    /**
         * 修改角色
         *@Param [role]
         * @return void
         **/
    void updateRole(Role role);
}
