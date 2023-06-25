package com.cm.controller;

import com.cm.entity.User;
import com.cm.response.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.Optional;

/**
 * 在返回时调用ResponseResult整合返回结果
 * @Author：CM
 * @Package：com.cm.controller
 * @Project：JavaReview
 * @name：DemoController
 * @Date：2023/6/25 15:31
 * @Filename：DemoController
 */

@RestController
@RequestMapping("demo")
public class DemoController {
    /**
     * @param user user param
     * @return user
     */
    @ApiOperation("Add/Edit User")
    @PostMapping("add")
    public ResponseResult<User> add(User user) {

        Optional<User> optional = Optional.ofNullable(user);
        if(optional.isPresent()){
            return ResponseResult.success(user);
        }else {
            return ResponseResult.fail("用户不存在");
        }
    /*    if (user.getId()==null || !userService.exists(user.getId())) {
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            userService.save(user);
        } else {
            user.setUpdateTime(LocalDateTime.now());
            userService.update(user);
        }
        return ResponseResult.success(userService.find(user.getId()));*/
    }


}
