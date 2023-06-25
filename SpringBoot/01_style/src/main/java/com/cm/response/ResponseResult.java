package com.cm.response;

import lombok.Builder;
import lombok.Data;

/**
 * @Author：CM
 * @Package：com.cm.response
 * @Project：JavaReview
 * @name：ResponseResult
 * @Date：2023/6/25 15:20
 * @Filename：ResponseResult
 */

@Data
@Builder
public class ResponseResult<T> {

    private long timestamp;

    private String status;

    private String message;

    private T data;


    /*默认返回成功响应方法*/
    public static <T> ResponseResult<T> success() {
        return success();
    }

    /*返回成功，响应data*/
    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder().data(data)
                .message(ResponseStatus.HTTP_STATUS_200.getDescription())
                .status(ResponseStatus.HTTP_STATUS_200.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /*默认响应失败方法，填充data为null*/
    public static <T> ResponseResult<T> fail(String message) {
        return fail(null, message);
    }

    /*响应失败，返回有效提示，而不是直接error*/
    public static <T> ResponseResult<T> fail(T data, String message) {
        return ResponseResult.<T>builder().data(data)
                .message(message)
                .status(ResponseStatus.HTTP_STATUS_400.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }
}
