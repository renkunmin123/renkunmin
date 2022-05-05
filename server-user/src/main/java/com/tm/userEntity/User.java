package com.tm.userEntity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String phoneNumber;
    private String sex;
    private Integer status;
    private Date birthday;
    private Date createDate;
    private Date updateDate;
    private String createUser;
    private String updateUser;
    private Integer isDelete;

    //新增用户时分配权限
    @TableField(exist = false)
    private List<Integer> roleList;
}
