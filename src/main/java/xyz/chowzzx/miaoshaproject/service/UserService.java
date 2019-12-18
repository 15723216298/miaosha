package xyz.chowzzx.miaoshaproject.service;

import xyz.chowzzx.miaoshaproject.service.model.UserModel;

/**
 * @author Chowzzx
 * @date 2019/12/13 - 1:13 PM
 */
public interface UserService {

    UserModel getById(Integer id);

    UserModel getByUserId(Integer id);
}
