package cn.edu.niit.servlet;

import cn.edu.niit.service.BooksService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName StoreBookServlet
 * @Description TODO
 * @Author SY
 * @Date 2021/4/22
 **/

@WebServlet(name = "StoreBookServlet", urlPatterns = "/book/store")
public class StoreBookServlet extends HttpServlet {

    private BooksService bookService = new BooksService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 取参（req当前的页码, 每页的数量, 搜索）
        String paramJson = IOUtils.toString(req.getInputStream(), "UTF-8");
        HashMap<String, Object> parseObject = JSON.parseObject(paramJson, HashMap.class);
        String username = (String) parseObject.get("user");
        String bookId = (String) parseObject.get("book");

        String message = bookService.storeBook(username, bookId);

        resp.getWriter().print(message);

    }
}
