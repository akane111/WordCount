package com.gaoge.entity;

import lombok.Data;

@Data
public class PasswordParam {
    private String oldPassword;
    private String newPassword;
}
