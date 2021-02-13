package com.zhangrichard.drugmanagement.service;

import com.zhangrichard.drugmanagement.model.UserPO;
import com.zhangrichard.drugmanagement.model.UserVO;

public interface UserService {

    UserVO getOneUserVOByName(String userName);
    UserPO getOneUserPOByName(String userName);
    UserVO getCurrentUser();
}
