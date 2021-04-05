package cn.edu.niit.service;

import cn.edu.niit.dao.LoginDao;
import cn.edu.niit.dao.RegisterDao;
import cn.edu.niit.domain.User;

import java.sql.SQLException;

/**
 * @ClassName RegisterService
 * @Description TODO
 * @Author SY
 * @Date 2021/4/5
 **/
public class RegisterService {
    private RegisterDao registerDao=new RegisterDao();
    LoginDao loginDao = new LoginDao();

    public String  register(User register) throws SQLException {
        String result=String.valueOf(registerDao.register(register));

        if (result.equals("0")){
            return "注册失败";
        }else {
            return "注册成功";
        }
    }
}
