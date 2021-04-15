package cn.edu.niit.servlet;

import cn.edu.niit.domain.Books;
import cn.edu.niit.service.BooksService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName SearchBooksServlet
 * @Description TODO
 * @Author SY
 * @Date 2021/4/13
 **/
//@WebServlet(name = "SearchBooksServlet", urlPatterns = "/book/search")
public class SearchBooksServlet extends HttpServlet {
    private BooksService booksService = new BooksService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramJson = IOUtils.toString(req.getInputStream(), "UTF-8");
        HashMap<String, Object> parseObject = JSON.parseObject(paramJson, HashMap.class);
        String param = (String) parseObject.get("search");
        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<Books> books = new ArrayList<>();
        int count = 0 ;
        if (param != null){

        }else {
            books = booksService.searchAllBooks(pageNum,
                    pageSize);
        }
        count = booksService.countNum();

        //3. 将结果放入session
        req.getSession().setAttribute("books", books);
        //将count直接作为ajax请求的结果返回
        resp.getWriter().print(count);

    }
}
