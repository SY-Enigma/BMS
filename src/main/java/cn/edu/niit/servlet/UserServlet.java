package cn.edu.niit.servlet;

import cn.edu.niit.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName UserServlet
 * @Description TODO
 * @Author SY
 * @Date 2021/3/23
 **/
@WebServlet(name = "UserServlet",urlPatterns = "/login")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.setCharacterEncoding("utf-8");
     resp.setCharacterEncoding("utf-8");
      String username = req.getParameter("username");
      String password = req.getParameter("password");

      String result = userService.login(username,password,req.getSession());
      if ("登录成功".equals(result)){
          resp.sendRedirect("/main.jsp");
      }else {
          req.getRequestDispatcher("/index.jsp?message=" + result).forward(req, resp);
      }




    }

}
