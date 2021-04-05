package cn.edu.niit.service;

import cn.edu.niit.dao.LoginDao;
import cn.edu.niit.domain.Admin;
import cn.edu.niit.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
                session.setAttribute("user", user);
                session.setAttribute("isLogin", true);
                return "登录成功";
            }else {
                return "密码错误";
            }
        }
    }

//  public  String register(String username, String password, HttpSession session){
//        User user = loginDao.selectOne(username);
//        if (user == null){
//            return "用户不存在";
//        }else{
//            if (password.equals(user.getPassword() == null)){
//                 return "注册成功";
//            }else
//            {
//                return "注册失败";
//            }
//
//        }
//  }


    public String adminLogin(String username, String password, HttpSession session) {
        Admin admin = loginDao.selectOne(username, password);
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
}
