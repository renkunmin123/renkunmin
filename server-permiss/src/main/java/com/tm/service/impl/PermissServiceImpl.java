package com.tm.service.impl;

import com.tm.entity.RoleASPermiss;
import com.tm.mapper.PermissMapper;
import com.tm.permissEntity.PermissEntity;
import com.tm.service.PermissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissServiceImpl implements PermissService{

    @Autowired
    private PermissMapper permissMapper;

    @Override
    public void insertPermiss(PermissEntity permissEntity) {
        permissMapper.insert(permissEntity);
    }

    @Override
    public void updatePermiss(PermissEntity permissEntity) {
        permissMapper.updateById(permissEntity);
    }

    @Override
    public List<PermissEntity> getPermiss() {
        List<PermissEntity> permissEntities = permissMapper.selectList(null);
        return permissEntities;
    }

    @Override
    public List<RoleASPermiss> queryRoleAsPermiss(Integer id) {
        List<RoleASPermiss> list=permissMapper.queryRoleAsPermiss(id);
        return list;
    }

    @Override
    public void deletePermiss(Integer id) {
        permissMapper.deleteById(id);
    }

    @Override
    public void deleteAll(List<Integer> ids) {
        permissMapper.deleteBatchIds(ids);
    }
}
