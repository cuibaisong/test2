package com.skynet.skynet_po_api.job.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse <T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    private Integer total;

    public APIResponse(String code, String message, T t,Integer total) {
        this.code = code;
        this.msg = message;
        this.data = t;
        this.total = total;
    }
    public APIResponse(String code, String message, T t,Long total) {
        this.code = code;
        this.msg = message;
        this.data = t;
        this.total = total.intValue();
    }
    /**
     * 返回成功，返回类型为服务器类型
     */
    public static <T> APIResponse<T> success() {
        return new APIResponse("0","操作成功",null, 0);
    }

    /**
     * 返回成功，返回类型为服务器类型
     */
    public static <T> APIResponse<T> success(T t) {
        return new APIResponse("0", "操作成功", t, 1);
    }
    /**
     * 返回成功，返回类型为服务器类型
     */
    public static <T> APIResponse<T> success(T t,Integer total) {
        return new APIResponse("0","操作成功", t,total);
    }
    public static <T> APIResponse<T> success(T t,Long total) {
        return new APIResponse("0","操作成功", t,total);
    }

    /**
     * 返回失败，自定义
     */
    public static <T> APIResponse<T> error() {
        return new APIResponse("1","操作失败", null, 0);
    }
    /**
     * 返回失败，自定义
     */
    public static <T> APIResponse<T> error(String msg) {
        return new APIResponse("1",msg, null, 0);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
