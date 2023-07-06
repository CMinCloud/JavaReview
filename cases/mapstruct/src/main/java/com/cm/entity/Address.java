package com.cm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Address
 * @Description TODO
 * @date 2023/7/6 14:19
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class Address {

    private String street;

    private Integer code;

    private Integer houseNo;

    private String description;
}
