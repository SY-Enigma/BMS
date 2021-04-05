package cn.edu.niit.servlet;

import cn.edu.niit.dao.LoginDao;
import cn.edu.niit.domain.User;
import cn.edu.niit.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @Author SY
 * @Date 2021/3/23
 **/
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private  LoginService loginService = new LoginService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.setCharacterEncoding("utf-8");
     resp.setCharacterEncoding("utf-8");
      String username = req.getParameter("username");
      String password = req.getParameter("password");

      String result = loginService.login(username,password,req.getSession());
      if ("登录成功".equals(result)){
          resp.sendRedirect("/main.jsp");
      }else {
          req.getRequestDispatcher("/index.jsp?message=" + result).forward(req, resp);
      }
    }

}
