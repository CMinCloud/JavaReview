package com.cm.entity.vo;

import lombok.Data;

/**
 * @ClassName UserWithAddressVo
 * @Description TODO
 * @date 2023/7/6 14:20
 * @Version 1.0
 */
@Data
public class UserWithAddressVo {

    private String username;
    private Integer sex;
    private String street;
    private Integer zipCode;
    private Integer houseNumber;
    private String description;

}
