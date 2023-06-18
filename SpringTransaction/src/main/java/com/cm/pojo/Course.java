package com.cm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author：CM
 * @Package：com.cm.pojo
 * @Project：JavaReview
 * @name：Course
 * @Date：2023/6/16 9:18
 * @Filename：Course
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private String id;

    private String title;

    private BigDecimal price;

    private Date gmtCreate;

    private Date gmtModified;

}
