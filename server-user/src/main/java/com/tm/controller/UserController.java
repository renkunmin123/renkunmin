package com.tm.controller;

import com.tm.service.UserService;
import com.tm.userEntity.User;
import com.tm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
         * 查询所有用户
         *@Param []
         * @return java.util.List<com.tm.userEntity.User>
         **/
    @GetMapping("getUser")
    @ResponseBody
    public Result getUser(){
        List<User> list=userService.getUser();
        return Result.success(list);
    }

    /**
         * 新增用户
         *@Param
         * @return
         **/
    @PostMapping("insertUser")
    public Result insertUser(@RequestBody User user){
        userService.insertUser(user);
        return Result.success();
    }

    /**
         * 删除用户
         *@Param
         * @return
         **/
    @GetMapping("deleteUser/{id}")
    public Result deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return Result.success();
    }

    /**
         * 修改用户
         *@Param
         * @return
         **/
    @PostMapping("updateUser")
    public Result updateUser(@RequestBody User user){
        userService.updateUser(user);
        return Result.success();
    }
}
