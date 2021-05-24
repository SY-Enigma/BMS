package cn.edu.niit.servlet;

import cn.edu.niit.service.BooksService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName deleteBooksServlet
 * @Description TODO
 * @Author SY
 * @Date 2021/5/23
 **/
@WebServlet(name = "deleteBooksServlet",urlPatterns = "/deleteBook")
public class deleteBooksServlet  extends HttpServlet {

    BooksService booksService = new BooksService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String id = req.getParameter("id");
        int message = booksService.delBooks(id);
        resp.getWriter().print(message);
    }


}
