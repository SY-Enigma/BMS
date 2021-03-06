package cn.edu.niit.servlet;

import cn.edu.niit.dao.UserDao;
import cn.edu.niit.domain.User;
import cn.edu.niit.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @ClassName RegisterServlet
 * @Description TODO
 * @Author SY
 * @Date 2021/4/5
 **/

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");


        User register = null;
        UserService registerService = new UserService();
        String result = "注册失败";
        //1【调用请求对象】读取【请求头】参数信息，得到用户注册信息
        String userName, password, reader;
        userName = req.getParameter("username");
        password = req.getParameter("password");
        reader = req.getParameter("reader");
        register = new User(userName, password, reader);
        // 先查询用户是否存在
        //2 调用userService——>userDao

        UserDao userDao = new UserDao();
        User byName = userDao.selectOne(register.getUsername());
        if (byName != null) {
            result = "用户已经存在";
        } else {
            try {
                result = registerService.register(register);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        //注册成功：——>跳转至登录页面进行登录
        //注册失败：——>注册页面提示：注册失败
        if (result.equals("注册成功")) {
            // 注册
            resp.sendRedirect("/index.jsp?message=" + result);
        } else {

            req.getRequestDispatcher("/register.jsp?message=" + result).forward(req, resp);

        }
    }
}
