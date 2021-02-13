package com.zhangrichard.drugmanagement.model;

import lombok.Data;

@Data
public class UserVO {

    private Long userId;
    private String userName;
    private String nickName;
    private Long departmentId;
    private String departmentName;
}
