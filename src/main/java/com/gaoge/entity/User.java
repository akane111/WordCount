package com.gaoge.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_user")
@ApiModel(description = "用户", value = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
//    @Column(name = "userName")
    private String userName;
    private String password;
    private String nickName;
    private String phone;
    private String identityNum;
    private String address;
    private String role;
    private Date createTime;
    private Date updateTime;
    private int integral;
    private int credit;
    private String avatar;

}
