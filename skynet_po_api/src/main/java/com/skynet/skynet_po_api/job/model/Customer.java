package com.skynet.skynet_po_api.job.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

@Data
@TableName("customer")
public class Customer extends Model<Customer> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    //客户名称
    @TableField(value = "name")
    private String name;

    //客户类型（个人/企业/政府）
    @TableField(value = "type")
    private String type;

    @TableField(value = "email")
    private String email;

    //联系人名称
    @TableField(value = "contacts_name")
    private String contactsName;

    //联系人电话
    @TableField(value = "contacts_phone")
    private String contactsPhone;

    //状态，是否启用（0否，1是）
    @TableField(value = "status")
    private Integer status;

    //是否授权媒体库（0否，1是）
    @TableField(value = "is_media_library")
    private Integer isMediaLibrary;

    //账号授权到期日期
    @TableField(value = "auth_time")
    private Date authTime;

    //最大启用管理员数量
    @TableField(value = "max_admin_num")
    private Integer maxAdminNum;

    //最大启用子账号数量
    @TableField(value = "max_sub_num")
    private Integer maxSubNum;

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
