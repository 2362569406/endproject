package org.user.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.user.pojo.UserInfo;
import org.user.service.dao.UserInfoMapper;
import org.user.service.util.CodecUtils;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    public Boolean registerUser(UserInfo userInfo){
        String s = CodecUtils.generateSalt();
        userInfo.setUserPwd(CodecUtils.md5Hex(userInfo.getUserPwd(), s));
        userInfo.setSalt(s);
        return userInfoMapper.insertSelective(userInfo)==1;
    }

    public Integer selMaxId(){
        return userInfoMapper.selMaxID();
    }

}
