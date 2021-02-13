package com.zhangrichard.drugmanagement.model;

import lombok.Data;

@Data
public class UserPO {

    private Long userId;
    private String userName;
    private String nickName;
    private String password;
    private Long departmentId;
}
