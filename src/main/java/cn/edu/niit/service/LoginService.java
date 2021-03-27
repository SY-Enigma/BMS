package cn.edu.niit.service;

import cn.edu.niit.dao.LoginDao;
import cn.edu.niit.domain.User;

import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginService
 * @Description TODO
 * @Author SY
 * @Date 2021/3/23
 **/
public class LoginService {

    private LoginDao  loginDao= new LoginDao();
    public  String login(String username, String password, HttpSession session) {
        User user = loginDao.selectOne(username);
        if (user == null){
            return  "用户不存在";
        }else {
            if (password.equals(user.getPassword())){

                return "登录成功";
            }else {
                return "密码错误";
            }
        }
    }
}
