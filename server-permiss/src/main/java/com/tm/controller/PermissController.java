package com.tm.controller;

import com.tm.entity.RoleASPermiss;
import com.tm.permissEntity.PermissEntity;
import com.tm.service.PermissService;
import com.tm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("permiss")
public class PermissController {

    @Autowired
    private PermissService permissService;

    /**
         * 新增权限
         *@Param [permissEntity]
         * @return void
         **/
    @PostMapping("insertPermiss")
    public Result insertPermiss(@RequestBody PermissEntity permissEntity){
        Date date = new Date();
        permissEntity.setCreateDate(date);
        permissService.insertPermiss(permissEntity);
        return Result.success();
    }

    /**
     * 修改权限
     *@Param [permissEntity]
     * @return void
     **/
    @PostMapping("updatePermiss")
    public Result updatePermiss(@RequestBody PermissEntity permissEntity){
        Date date = new Date();
        permissEntity.setUpdateDate(date);
        permissService.updatePermiss(permissEntity);
        return Result.success();
    }

    /**
         * 查询所有权限
         *@Param
         * @return
         **/
    @GetMapping("getPermiss")
    public Result getPermiss(){
        List<PermissEntity> list=permissService.getPermiss();
        return Result.success(list);
    }

    /**
         * 删除权限
         *@Param
         * @return
         **/
    @GetMapping("deletePermiss/{id}")
    public Result deletePermiss(@PathVariable Integer id){
        List<RoleASPermiss> list=permissService.queryRoleAsPermiss(id);
        if(list.size()>0){
            return Result.error("请取消角色关联后重试");
        }else{
            permissService.deletePermiss(id);
        }
        return Result.success();
    }

    /**
         * 批量删除角色对应权限
         *@Param
         * @return
         **/
    @PostMapping("deleteAll")
    public void deleteAll(@RequestBody List<Integer> ids){
        permissService.deleteAll(ids);
    }
}
