package xyz.chowzzx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import xyz.chowzzx.miaoshaproject.dao.UserDOMapper;
import xyz.chowzzx.miaoshaproject.dataobject.UserDO;

/**
 * Hello world!
 *
 */
//开启整个工程内SpringBoot的自动化配置
@SpringBootApplication
@MapperScan(basePackages = "xyz.chowzzx.miaoshaproject.dao")
@RestController
public class App {

    @Autowired
    private UserDOMapper userDOMapper;

    @GetMapping("/test")
    public UserDO test(@RequestParam int id){
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        return userDO;

    }

    public static void main( String[] args ) {
        //启动项目
        SpringApplication.run(App.class,args);
    }
}
