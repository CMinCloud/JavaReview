package com.cm.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2023-06-28 21:31:23
 */
@SuppressWarnings("serial")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sys_user")
public class User {
    //主键
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //用户名
    @Column(name = "user_name")
    private String userName;
    //昵称
    @Column(name = "nick_name")
    private String nickName;
    //密码
    @Column(name = "password")
    private String password;
    //账号状态（0正常 1停用）
    @Column(name = "status")
    private String status;
    //邮箱
    @Column(name = "email")
    private String email;
    //手机号
    @Column(name = "phonenumber")
    private String phonenumber;
    //用户性别（0男，1女，2未知）
    @Column(name = "sex")
    private String sex;
    //头像
    @Column(name = "avatar")
    private String avatar;
    //用户类型（0管理员，1普通用户）
    @Column(name = "user_type")
    private String userType;
    //创建人的用户id
    @Column(name = "createBy")
    private Long createBy;
    //创建时间
    @Column(name = "create_time")
    private Date createTime;
    //更新人
    @Column(name = "update_by")
    private Long updateBy;
    //更新时间
    @Column(name = "update_time")
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    @Column(name = "del_flag")
    private Integer delFlag;

}

