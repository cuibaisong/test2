package com.skynet.skynet_po_api.job.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

@Data
@TableName("news_info")
public class NewsInfo extends Model<NewsInfo> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    //平台名称
    @TableField(value = "platform_name")
    private String platformName;

    //平台类型
    @TableField(value = "platform_type")
    private String platformType;

    //一级域名
    @TableField(value = "platform_domain_fir")
    private String platformDomainFir;

    //二级域名
    @TableField(value = "platform_domain_sec")
    private String platformDomainSec;

    //媒体账号名称
    @TableField(value = "media_name")
    private String mediaName;

    //媒体账号ID
    @TableField(value = "media_id")
    private Integer mediaId;

    //媒体类型（记者/大V/官媒...）
    @TableField(value = "media_type")
    private String mediaType;

    //媒体账号唯一标识
    @TableField(value = "media_uuid")
    private String mediaUuid;

    //媒体账号头像
    @TableField(value = "media_picurl")
    private String mediaPicurl;

    //媒体账号省份
    @TableField(value = "media_province")
    private String mediaProvince;

    //媒体账号城市
    @TableField(value = "media_city")
    private String mediaCity;

    //文章唯一标识
    @TableField(value = "news_uuid")
    private String newsUuid;

    //文章标题
    @TableField(value = "news_title")
    private String newsTitle;

    //文章摘要
    @TableField(value = "news_abstract")
    private String newsAbstract;

    //文章链接
    @TableField(value = "news_url")
    private String newsUrl;

    //文章内容
    @TableField(value = "news_content")
    private String newsContent;

    //情感属性（中负正等）
    @TableField(value = "news_emotion")
    private String newsEmotion;

    //文章发文时间
    @TableField(value = "news_post_time")
    private Date newsPostTime;

    //文章入库时间
    @TableField(value = "news_storage_time")
    private Date newsStorageTime;

    //文章作者
    @TableField(value = "news_author")
    private String newsAuthor;

    //文章内容提及地区
    @TableField(value = "news_content_area")
    private String newsContentArea;

    //文章领域类别
    @TableField(value = "news_content_field")
    private String newsContentField;

    //文章是否原创（0否，1是）
    @TableField(value = "news_is_original")
    private Integer newsIsOriginal;

    //原文链接
    @TableField(value = "news_origin_url")
    private String newsOriginUrl;

    //原文作者
    @TableField(value = "news_origin_author_name")
    private String newsOriginAuthorName;

    //关键词列表
    @TableField(value = "news_keywords_list")
    private String newsKeywordsList;

    //文章图片链接
    @TableField(value = "news_img_urls")
    private String newsImgUrls;

    //文章视频链接
    @TableField(value = "news_video_urls")
    private String newsVideoUrls;

    //文章阅读量
    @TableField(value = "news_read_vol")
    private Integer newsReadVol;

    //文章评论数
    @TableField(value = "news_comment_vol")
    private Integer newsCommentVol;

    //文章点赞数
    @TableField(value = "news_likes_vol")
    private Integer newsLikesVol;

}
