package com.zhangrichard.drugmanagement.mapper;

import com.zhangrichard.drugmanagement.model.UserPO;
import com.zhangrichard.drugmanagement.model.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select(" SELECT u.userId, u.userName, u.nickName, d.departmentId, d.departmentName " +
            " FROM user u " +
            " LEFT JOIN department d ON u.departmentId = d.departmentId " +
            " WHERE u.userName = #{userName}; ")
    UserVO getOneUserVOByName(String userName);


    @Select(" SELECT userId, userName, nickName, password, departmentId " +
            " FROM user " +
            " WHERE userName = #{userName}; ")
    UserPO getOneUserPOByName(String userName);
}
