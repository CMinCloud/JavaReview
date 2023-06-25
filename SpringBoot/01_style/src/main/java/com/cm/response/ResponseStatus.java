package com.cm.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * @Author：CM
 * @Package：com.cm.response
 * @Project：JavaReview
 * @name：ResponseStatus
 * @Date：2023/6/25 15:17
 * @Filename：ResponseStatus
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus {


    SUCCESS("200","success"),

    FAIL("500","failed"),

    HTTP_STATUS_200("200","ok"),

    HTTP_STATUS_400("400","request error"),

    HTTP_STATUS_401("401","no authentication"),

    HTTP_STATUS_403("403","no authorities"),

    HTTP_STATUS_500("500","server error");




    /**
     * response code
     */
    private final String responseCode;

    /**
     * description.
     */
    private final String description;

}
