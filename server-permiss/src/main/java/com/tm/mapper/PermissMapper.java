package com.tm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tm.entity.RoleASPermiss;
import com.tm.permissEntity.PermissEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissMapper extends BaseMapper<PermissEntity> {
    List<RoleASPermiss> queryRoleAsPermiss(Integer id);
}
