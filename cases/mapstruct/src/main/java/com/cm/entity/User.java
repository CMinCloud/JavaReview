package com.cm.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description TODO
 * @date 2023/7/6 11:01
 * @Version 1.0
 */
@Data
@Accessors(chain = true) //使用该注解：使用set方法后，会返回当前对象
public class User {

    private Long id;
    private String username;
    private String password; // 密码
    private Integer sex;  // 性别
    private LocalDate birthday; // 生日
    private LocalDateTime createTime; // 创建时间
    private String config; // 其他扩展信息，以JSON格式存储
}
