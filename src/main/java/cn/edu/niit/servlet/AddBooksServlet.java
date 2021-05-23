package cn.edu.niit.servlet;

import cn.edu.niit.service.BooksService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AddBooksServlet
 * @Description TODO
 * @Author SY
 * @Date 2021/4/25
 **/
@WebServlet(name = "AddBooksServlet", urlPatterns = "/addBooks")
public class AddBooksServlet extends HttpServlet {

    BooksService  booksService = new BooksService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {


        String name = req.getParameter("name");
        String author =  req.getParameter("author");
        String description = req.getParameter("description");

        String  message = booksService.addBook(name, author, description);
        resp.getWriter().print(message);

    }
}
