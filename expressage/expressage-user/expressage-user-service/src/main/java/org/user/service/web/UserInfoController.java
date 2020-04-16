package org.user.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.user.pojo.UserInfo;
import org.user.service.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public ResponseEntity<UserInfo> Loning(@RequestParam("username")String username
            ,@RequestParam("password")String password){
        UserInfo login = userInfoService.Login(username, password);
        if (login == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(login);
    }

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
