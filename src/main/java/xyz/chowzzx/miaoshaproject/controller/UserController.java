package xyz.chowzzx.miaoshaproject.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.chowzzx.miaoshaproject.controller.viewobject.UserVO;
import xyz.chowzzx.miaoshaproject.error.BusinessException;
import xyz.chowzzx.miaoshaproject.error.EmBusinessError;
import xyz.chowzzx.miaoshaproject.response.CommonReturnType;
import xyz.chowzzx.miaoshaproject.service.UserService;
import xyz.chowzzx.miaoshaproject.service.model.UserModel;

/**
 * @author Chowzzx
 * @date 2019/12/19 - 9:45 AM
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam("id")Integer id) throws BusinessException {
        //调用service层获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);
        if(userModel == null){
            userModel.setEncrptPassword("123");
            //throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        UserVO userVO = convertFromModel(userModel);
        CommonReturnType commonReturnType = CommonReturnType.create(userVO);
        return commonReturnType;
    }

    //用户获取otp短信接口
    @GetMapping("/getotp")
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam("telphone")String telphone){
        //生成OTP验证码
        //将验证码和手机号关联
        //将OTP验证码通过短信通道发送给用户。省略
    }


    public UserVO convertFromModel(UserModel userModel){
        if(userModel ==null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }
}
