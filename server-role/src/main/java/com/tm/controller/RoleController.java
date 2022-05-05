package com.tm.controller;

import com.tm.ServiceClient.PermissClient;
import com.tm.entity.UserASRole;
import com.tm.roleEntity.Role;
import com.tm.service.RoleService;
import com.tm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissClient permissClient;

    /**
         * 查询所有角色
         *@Param []
         * @return com.tm.utils.Result
         **/
    @GetMapping("getRole")
    public Result getRole(){
        List<Role> list=roleService.getRole();
        return Result.success(list);
    }

    /**
         * 删除角色
         *@Param
         * @return
         **/
    @GetMapping("deleteRole/{id}")
    public Result deleteRole(@PathVariable Integer id){
        List<UserASRole> list=roleService.queryUserAsRole(id);
        if(list.size()>0){
            return Result.error("请取消用户关联后重试");
        }else{
            roleService.deleteRole(id);
        }
        return Result.success();
    }

    /**
     * 新增角色
     *@Param
     * @return
     **/
    @PostMapping("insertRole")
    public Result insertRole(@RequestBody Role role){
        roleService.insertRole(role);
        return Result.success();
    }

    /**
         * 修改角色
         *@Param
         * @return
         **/
    @Transactional
    @PostMapping("updateRole")
    public void updateRole(@RequestBody Role role){
        roleService.deleteAllPermissList(role.getId());
        roleService.updateRole(role);
    }
}
