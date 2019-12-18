package xyz.chowzzx.miaoshaproject.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.chowzzx.miaoshaproject.dao.UserDOMapper;
import xyz.chowzzx.miaoshaproject.dao.UserPasswordDOMapper;
import xyz.chowzzx.miaoshaproject.dataobject.UserDO;
import xyz.chowzzx.miaoshaproject.dataobject.UserPasswordDO;
import xyz.chowzzx.miaoshaproject.service.UserService;
import xyz.chowzzx.miaoshaproject.service.model.UserModel;

/**
 * @author Chowzzx
 * @date 2019/12/13 - 1:14 PM
 */
@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getByUserId(Integer id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        UserModel userModel = convert2UserModel(userDO, userPasswordDO);
        return userModel;
    }

    public UserModel getById(Integer id){
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByPrimaryKey(id);
        UserModel userModel = convert2UserModel(userDO, userPasswordDO);
        return userModel;
    }



    public UserModel convert2UserModel(UserDO userDO, UserPasswordDO userPasswordDO){
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO,userModel);
        userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        return userModel;
    }
}
