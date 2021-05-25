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

    /**
     * 查询图书
     * @return
     */
    public List<Books> searchAllBooks(int pageNum, int pageSize){
        List<Books> books = booksDao.selectAll(pageNum, pageSize);
        return books;
    }


    public  int countNum(){
        return booksDao.selectAllCount();
    }

    /**
     * 查询收藏图书
     * @return
     */
    public  List<Books> selectStoreBooks(int pageNum, int pageSize,String id){
        List<Books> books = booksDao.selectAllStore(pageNum, pageSize,id);
        return books;
    }
    public  int countStoreNum(String userId){
        return  booksDao.countStore(userId);
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
    /**
     * 再借图书
     * @return
     */
    public  List<Books> selectBorrowBook(int pageNum, int pageSize,String id){
        List<Books>  books = booksDao.selectBorrowBooks(pageNum, pageSize,id);
        return  books;
    }
    public  int countBorrowNum( String userId){
        return  booksDao.countBorrowBooks(userId);
    }


    /**
     * 借阅图书历史
     *
     * @return
     */
    public  List<Books> selectBorrowHistoryBooks(int pageNum, int pageSize,String id){
        List<Books> books = booksDao.selectBorrowHistoryBooks(pageNum, pageSize,id);
        return books;
    }
    public  int countBorrowHistoryNum(String userId){
        return  booksDao.countBorrowHistoryBooks(userId);
    }


    /**
     * 增加图书
     * @return
     */
    public String addBook(String name,String author,String description){
        int result = booksDao.addBooks(name,author,description);
        if (result > 0){
            return  "添加图书成功";
        }else {
            return "添加图书失败";
        }
    }
    /**
     * 删除图书
     * @return
     */
    public int delBooks(String id){
        return  booksDao.deleteBooks(id);

    }

}
