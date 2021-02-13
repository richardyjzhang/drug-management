package com.zhangrichard.drugmanagement.service.impl;

import com.zhangrichard.drugmanagement.mapper.UserMapper;
import com.zhangrichard.drugmanagement.model.UserPO;
import com.zhangrichard.drugmanagement.model.UserVO;
import com.zhangrichard.drugmanagement.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVO getOneUserVOByName(String userName) {
        UserVO user = userMapper.getOneUserVOByName(userName);
        return user;
    }

    @Override
    public UserPO getOneUserPOByName(String userName) {
        UserPO user = userMapper.getOneUserPOByName(userName);
        return user;
    }

    @Override
    public UserVO getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        UserVO user = (UserVO)session.getAttribute("CurrentUser");
        return user;
    }
}
