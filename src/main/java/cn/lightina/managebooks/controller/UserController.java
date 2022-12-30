package cn.lightina.managebooks.controller;

import cn.lightina.managebooks.dao.BookMapper;
import cn.lightina.managebooks.pojo.AjaxResult;
import cn.lightina.managebooks.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/managebooks")
public class UserController {

    @Resource
    BookMapper bookMapper;

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @PostMapping(value = "/addUserInfo")
    public AjaxResult addUserInfo(@RequestBody User user) {
        try{
            //1:管理员，2：读者
            Integer roleTYpe = user.getRoleType();
            int count = 0;
            if(roleTYpe!=null && roleTYpe==2){
                count = bookMapper.addAdminInfo(user);
            }else{
                count = bookMapper.addReaderInfo(user);
            }
            if(count<=0){
                return AjaxResult.error("该手机号或者已经被注册!");
            }
            return AjaxResult.success("注册成功");
        }catch (Exception e){
            return AjaxResult.error("添加用户信息异常");
        }
    }


}
