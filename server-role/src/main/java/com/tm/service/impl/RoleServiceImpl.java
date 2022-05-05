package com.tm.service.impl;

import com.tm.entity.RoleASPermiss;
import com.tm.entity.UserASRole;
import com.tm.mapper.RoleMapper;
import com.tm.roleEntity.Role;
import com.tm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRole() {
        List<Role> list=roleMapper.selectList(null);
        return list;
    }

    @Override
    public List<UserASRole> queryUserAsRole(Integer id) {
        List<UserASRole> list=roleMapper.queryUserAsRole(id);
        return list;
    }

    @Override
    @Transactional
    public void deleteRole(Integer id) {
        roleMapper.deleteRoleAsPermiss(id);
        roleMapper.deleteById(id);
    }

    @Override
    public void insertRole(Role role) {
        Date date = new Date();
        role.setCreateDate(date);
        roleMapper.insert(role);
        List<Integer> permissList = role.getPermissList();
        RoleASPermiss roleASPermiss = new RoleASPermiss();
        roleASPermiss.setRoleId(role.getId());
        roleASPermiss.setCreateDate(date);
        for (int i=0;i<permissList.size();i++){
            roleASPermiss.setPermissionId(permissList.get(i));
            roleMapper.insertRoleASPermiss(roleASPermiss);
        }
    }

    @Override
    public void deleteAllPermissList(Integer id) {
        roleMapper.deleteRoleAsPermiss(id);
    }

    @Override
    public void updateRole(Role role) {
        Date date = new Date();
        role.setUpdateDate(date);
        roleMapper.updateById(role);
        List<Integer> permissList = role.getPermissList();
        RoleASPermiss roleASPermiss = new RoleASPermiss();
        roleASPermiss.setRoleId(role.getId());
        roleASPermiss.setCreateDate(date);
        for (int i=0;i<permissList.size();i++){
            roleASPermiss.setPermissionId(permissList.get(i));
            roleMapper.insertRoleASPermiss(roleASPermiss);
        }
    }


}
