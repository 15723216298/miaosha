package xyz.chowzzx.miaoshaproject.service;

import xyz.chowzzx.miaoshaproject.service.model.UserModel;

/**
 * @author Chowzzx
 * @date 2019/12/19 - 9:47 AM
 */
public interface UserService {

    //通过用户id获取用户对象
    UserModel getUserById(Integer id);
}
