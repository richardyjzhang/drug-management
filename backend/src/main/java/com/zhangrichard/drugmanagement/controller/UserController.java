package com.zhangrichard.drugmanagement.controller;

import com.zhangrichard.drugmanagement.model.LoginResult;
import com.zhangrichard.drugmanagement.model.LoginUser;
import com.zhangrichard.drugmanagement.model.UserVO;
import com.zhangrichard.drugmanagement.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drug-management")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResult> login(@RequestBody LoginUser user) {

        LoginResult result = new LoginResult();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());

        try {
            subject.login(token);

            UserVO curUser = userService.getOneUserVOByName(user.getUserName());
            Session session = subject.getSession();
            session.setAttribute("CurrentUser", curUser);

            result.setSuccess(true);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setErrMessage("用户名或密码错误");
        }

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/current-user")
    public ResponseEntity<UserVO> getCurrentUser() {

        UserVO user = userService.getCurrentUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
