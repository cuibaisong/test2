package com.skynet.skynet_po_api.job.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

@Data
@TableName("customer_user")
public class CustomerUser extends Model<CustomerUser> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    //客户ID
    @TableField(value = "customer_id")
    private Integer customerId;

    //用户昵称
    @TableField(value = "nick_name")
    private String nickName;

    //用户类型（0超管，1普通）
    @TableField(value = "type")
    private Integer type;

    //登录账号
    @TableField(value = "account")
    private String account;

    //登录密码
    @TableField(value = "pwd")
    private String pwd;

    @TableField(value = "email")
    private String email;

    @TableField(value = "phone")
    private String phone;

    //性别（0女，1男）
    @TableField(value = "gender")
    private Integer gender;

    //状态，是否启用（0否，1是）
    @TableField(value = "status")
    private Integer status;

    //是否删除（0未删除，1已删除）
    @TableField(value = "is_del")
    private Integer isDel;

    //最后登录IP
    @TableField(value = "login_ip")
    private String loginIp;

    //最后登录时间
    @TableField(value = "login_time")
    private Date loginTime;

    //创建时间
    @TableField(value = "c_time")
    private Date cTime;

    //创建人
    @TableField(value = "creater_id")
    private Integer createrId;

    //最后修改时间
    @TableField(value = "last_upd_time")
    private Date lastUpdTime;

    //最后修改人
    @TableField(value = "last_upd_user")
    private Integer lastUpdUser;

    //备注
    @TableField(value = "remark")
    private String remark;
}
