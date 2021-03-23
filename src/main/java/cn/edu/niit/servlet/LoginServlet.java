package cn.edu.niit.servlet;

import cn.edu.niit.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @Author SY
 * @Date 2021/3/23
 **/
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.setCharacterEncoding("utf-8");
     resp.setCharacterEncoding("utf-8");
      String username = req.getParameter("username");
      String password = req.getParameter("password");

      String result = LoginService.login(username,password,req.getSession());
      if ("1".equals(result)){
          resp.sendRedirect("/main.jsp");
      }else {
          req.getRequestDispatcher("/index.jsp?message=" + result).forward(req, resp);
      }
    }


}
