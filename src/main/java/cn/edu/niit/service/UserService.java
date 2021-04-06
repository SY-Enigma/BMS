package cn.edu.niit.service;

import cn.edu.niit.dao.UserDao;
import cn.edu.niit.domain.Admin;
import cn.edu.niit.domain.User;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author SY
 * @Date 2021/3/23
 **/
public class UserService {

    private UserDao userDao = new UserDao();

    public  String login(String username, String password, HttpSession session) {
        User user = userDao.selectOne(username);
        if (user == null){
            return  "用户不存在";
        }else {
            if (password.equals(user.getPassword())){
                session.setAttribute("user", user);
                session.setAttribute("isLogin", true);
                return "登录成功";
            }else {
                return "密码错误";
            }
        }
    }




    public String adminLogin(String username, String password, HttpSession session) {
        Admin admin = userDao.selectOne(username, password);
        if (admin == null) {
            return "用户不存在";
        } else {
            if (password.equals(admin.getPassword())) {
                session.setAttribute("admin", admin);
                session.setAttribute("isLogin", true);
                return "登录成功";
            } else {
                return "密码错误";
            }
        }
    }
    public String  register(User register) throws SQLException {
        String result=String.valueOf(userDao.register(register));

        if (result.equals("0")){
            return "注册失败";
        }else {
            return "注册成功";
        }
    }
}
