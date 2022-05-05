package com.tm.service;

import com.tm.entity.RoleASPermiss;
import com.tm.permissEntity.PermissEntity;

import java.util.List;

public interface PermissService {
    /**
         * 新增权限
         *@Param [permissEntity]
         * @return void
         **/
    void insertPermiss(PermissEntity permissEntity);

    /**
     * 修改权限
     *@Param [permissEntity]
     * @return void
     **/
    void updatePermiss(PermissEntity permissEntity);

    /**
         * 查询所有权限
         *@Param []
         * @return java.util.List<com.tm.permissEntity.PermissEntity>
         **/
    List<PermissEntity> getPermiss();

    /**
         * 根据权限id查询角色
         *@Param [id]
         * @return java.util.List<com.tm.entity.RoleASPermiss>
         **/
    List<RoleASPermiss> queryRoleAsPermiss(Integer id);

    /**
         * 删除权限
         *@Param [id]
         * @return void
         **/
    void deletePermiss(Integer id);

    /**
         * 批量删除角色对应权限
         *@Param [ids]
         * @return void
         **/
    void deleteAll(List<Integer> ids);
}
