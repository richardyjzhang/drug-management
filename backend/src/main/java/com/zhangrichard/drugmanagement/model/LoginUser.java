package com.zhangrichard.drugmanagement.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginUser {

    @NotNull
    private String userName;
    @NotNull
    private String password;
}
