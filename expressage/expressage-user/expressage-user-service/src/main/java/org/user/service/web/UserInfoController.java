package org.user.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.user.pojo.UserInfo;
import org.user.service.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 注册
     * @param userInfo
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(UserInfo userInfo){
        if (userInfoService.selMaxId() == null){
            userInfo.setUserId(1);
        }else{
            userInfo.setUserId(userInfoService.selMaxId());
        }
        Boolean aBoolean = userInfoService.registerUser(userInfo);
        if (aBoolean){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }
}
