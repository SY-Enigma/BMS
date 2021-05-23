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


    public boolean isStore(String username, String bookId) {
        return booksDao.selectStore(username, bookId);
    }

    public String storeBook(String username, String bookId) {
        int result = booksDao.insertStoreBook(username, bookId);
        if (result > 0) {
            return "借阅成功";
        } else {
            return "借阅失败";
        }
    }


    public String addBook(String name,String author,String description){
        int result = booksDao.addBooks(name,author,description);
        if (result > 0){
            return  "添加图书成功";
        }else {
            return "添加图书失败";
        }
    }

    public int delBooks(String id){
        return  booksDao.deleteBooks(id);

    }

}
