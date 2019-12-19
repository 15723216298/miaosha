package xyz.chowzzx.miaoshaproject.service.model;

import lombok.Data;

/**
 * @author Chowzzx
 * @date 2019/12/19 - 9:52 AM
 */
@Data
public class UserModel {

    private Integer id;
    private String name;
    private Integer age;
    private Byte gender;
    private String telphone;
    private String registerMode;
    private String thirdPartyId;

    private String encrptPassword;
}
