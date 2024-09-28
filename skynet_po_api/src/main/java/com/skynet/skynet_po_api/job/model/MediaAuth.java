package com.skynet.skynet_po_api.job.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

@Data
@TableName("media_auth")
public class MediaAuth extends Model<MediaAuth> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    //媒体名称
    @TableField(value = "name")
    private String name;

    //媒体类型（大V/记者/平台）
    @TableField(value = "type")
    private String type;

    //媒体平台
    @TableField(value = "media_platform")
    private String mediaPlatform;

    //真实姓名
    @TableField(value = "real_name")
    private String realName;

    //状态，是否启用（0否，1是）
    @TableField(value = "status")
    private Integer status;

    //是否删除（0未删除，1已删除）
    @TableField(value = "is_del")
    private Integer isDel;

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
}
