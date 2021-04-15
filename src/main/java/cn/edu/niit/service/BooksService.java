package cn.edu.niit.service;

import cn.edu.niit.dao.BooksDao;
import cn.edu.niit.domain.Books;

import java.util.List;

/**
 * @ClassName BooksService
 * @Description TODO
 * @Author SY
 * @Date 2021/4/13
 **/
public class BooksService {
    private BooksDao booksDao = new BooksDao();
    public List<Books> searchAllBooks(int pageNum, int pageSize){
        List<Books> books = booksDao.selectAll(pageNum, pageSize);
        return books;
    }
    public  int countNum(){
        return booksDao.selectAllCount();
    }
}
