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
 * @date 2019/12/19 - 9:48 AM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id) {
        //调用userDOMapper获取对应的dataObject
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if(userDO == null){
            return null;
        }
        //UserModel不仅包含了userDo，还有一个encrptPassword属性
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        UserModel userModel = convertFromDataObject(userDO, userPasswordDO);
        return userModel;
    }

    public UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO){
        UserModel userModel = new UserModel();
        if(userDO == null){
            return null;
        }
        BeanUtils.copyProperties(userDO,userModel);
        if(userPasswordDO != null){
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }
        return userModel;
    }
}
