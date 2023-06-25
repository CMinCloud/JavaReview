package com.cm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：CM
 * @Package：com.cm.entity
 * @Project：JavaReview
 * @name：User
 * @Date：2023/6/25 15:47
 * @Filename：User
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long Id;

    private String name;

    private int age;

}
