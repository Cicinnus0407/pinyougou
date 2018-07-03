package com.pinyougou.entity;

import java.io.Serializable;

/**
 * @author cicinnus
 * @date 2018/6/28
 */
public class Result implements Serializable {
    private boolean success;
    private String message;

    public static Result create(boolean success, String message) {
        return new Result(success, message);
    }

    public static Result success() {
        return new Result(true, "操作成功");
    }

    public static Result fail(String message) {
        return new Result(false, message);
    }

    public static Result fail() {
        return new Result(false, "操作失败");
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
