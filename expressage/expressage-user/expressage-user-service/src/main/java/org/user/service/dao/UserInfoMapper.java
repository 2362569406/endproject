package org.user.service.dao;

import org.apache.ibatis.annotations.Select;
import org.user.pojo.UserInfo;
import tk.mybatis.mapper.common.Mapper;

public interface UserInfoMapper extends Mapper<UserInfo> {
    @Select("SELECT MAX(user_id)+1 FROM userInfo")
    Integer selMaxID();
}
