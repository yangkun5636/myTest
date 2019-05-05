package com.ben.simpleshiro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yangkun
 */
@Data
@AllArgsConstructor
public class ResponseDto implements Serializable {
    private static final long serialVersionUID = -9145998834340944241L;
    private static final String CODE_SUCCESS = "00000";
    private static final String CODE_FAILED = "99999";
    private static final String MESSAGE_SAVE_SUCCESS = "保存成功!";
    private static final String MESSAGE_SAVE_FAILED = "保存失败!";
    private static final String MESSAGE_DELETE_SUCCESS = "删除成功!";
    private static final String MESSAGE_DELETE_FAILED = "删除失败!";
    private static final String MESSAGE_QUERY_SUCCESS = "查询成功!";
    private static final String MESSAGE_QUERY_FAILED = "查询失败!";
    private static final String MESSAGE_OPERATE_SUCCESS = "操作成功!";
    private static final String MESSAGE_OPERATE_FAILED = "操作失败!";
    private static final String STATUS_SUCCESS = "0";
    private static final String STATUS_FAILED = "1";
    private static final String CONTENT_DEFAULT = "";

    /**
     * 返回代码
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回状态
     */
    private String status;
    /**
     * 返回内容
     */
    private String content;

    public static ResponseDto success() {
        return new ResponseDto(CODE_SUCCESS, MESSAGE_OPERATE_SUCCESS, STATUS_SUCCESS, CONTENT_DEFAULT);
    }

    public static ResponseDto failed() {
        return new ResponseDto(CODE_FAILED, MESSAGE_OPERATE_FAILED, STATUS_FAILED, CONTENT_DEFAULT);
    }

    public static ResponseDto failed(String content) {
        return new ResponseDto(CODE_FAILED, MESSAGE_OPERATE_FAILED, STATUS_FAILED, content);
    }

    public static ResponseDto saveSuccess() {
        return new ResponseDto(CODE_SUCCESS, MESSAGE_SAVE_SUCCESS, STATUS_SUCCESS, CONTENT_DEFAULT);
    }
}
