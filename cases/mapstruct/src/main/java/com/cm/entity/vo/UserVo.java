package com.cm.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

/**
 * @ClassName UserVo
 * @Description TODO
 * @date 2023/7/6 11:07
 * @Version 1.0
 */
@Data
@Accessors(chain = true)   //使用set方法会返回原对象，适用于链式编程、类似建造者模式
public class UserVo {

    private Long id;
    private String username;
    private String password;
    private Integer gender;
    private LocalDate birthday;
    private String createTime;
    private List<UserConfig> config;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserConfig {
        private String field1;
        private Integer field2;
    }
}
