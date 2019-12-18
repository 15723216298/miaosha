package xyz.chowzzx.miaoshaproject.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.chowzzx.miaoshaproject.controller.viewobject.UserVO;
import xyz.chowzzx.miaoshaproject.dao.UserDOMapper;
import xyz.chowzzx.miaoshaproject.dataobject.UserDO;
import xyz.chowzzx.miaoshaproject.service.UserService;
import xyz.chowzzx.miaoshaproject.service.model.UserModel;

/**
 * @author Chowzzx
 * @date 2019/12/13 - 1:11 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDOMapper userDOMapper;

    @GetMapping("/get")
    public UserVO getUser(@RequestParam("id") Integer id){
        UserModel userModel = userService.getByUserId(id);
        UserVO userVO = convert2UserVO(userModel);
        return userVO;
    }




    //将核心领域模型对象转换成前端使用的view object对象。
    public UserVO convert2UserVO(UserModel userModel){
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }
}
