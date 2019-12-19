package xyz.chowzzx.miaoshaproject.response;

import lombok.Data;

/**
 * @author Chowzzx
 * @date 2019/12/19 - 10:28 AM
 */
@Data
public class CommonReturnType {

    //success,fail
    private String status;

    //status=success，则data返回json数据
    //status=fail，则data返回通用错误码格式
    private Object data;

    //定义通用的创建方法
    public static CommonReturnType create(Object result){
        return create(result,"success");
    }

    public static CommonReturnType create(Object result,String status){
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setStatus(status);
        commonReturnType.setData(result);
        return commonReturnType;
    }
}
