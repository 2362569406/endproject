package org.user.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.pojo.UserInfo;
import org.user.service.dao.UserInfoMapper;
import org.user.service.util.CodecUtils;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    public UserInfo Login(String username,String password){
        UserInfo recode = new UserInfo();
        recode.setUserName(username);
        UserInfo userInfo = userInfoMapper.selectOne(recode);
        if (userInfo == null){
            return null;
        }
        String salt = userInfo.getSalt();
        if (!CodecUtils.md5Hex(password,salt).equals(userInfo.getUserPwd())){
            return null;
        }
        return userInfo;
    }

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
