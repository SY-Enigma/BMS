package cn.edu.niit.dao;

import cn.edu.niit.db.JDBCUtil;
import cn.edu.niit.domain.Books;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BooksDao
 * @Description TODO
 * @Author SY
 * @Date 2021/4/13
 **/
public class BooksDao {


    /**
     * 查询图书
     * @return
     */
    public List<Books> selectAll(int pageNum, int pageSize){
        String sql = "select books.*, book_sort.name as sort from " + "books, " + "book_sort where books.sort_id=book_sort.id limit " + "?,?";
        List<Books> books =new ArrayList<>();
        try(ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql,
                new Object[]{(pageNum - 1) * pageSize, pageSize})) {
            while (rs.next()){
                Books book = new Books(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getString("sort"),
                        rs.getString("description"),
                        rs.getBoolean("store"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    /**
     * 统计图书数量
     * @return
     */
    public int selectAllCount() {
        String sql = "select count(*) as num from books";
        try (final ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{})) {
            while (rs.next()) {
                return rs.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }


    /**
     * 查询收藏图书
     * @return
     */
    public boolean selectStore(String username, String bookId) {
        String sql1 = "select EXISTS( SELECT 1 from borrow_books " +
                "where book_id=? and card_id=?) as store";
        try (ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql1,
                             new Object[]{
                                     bookId, username
                             });) {

            while (rs.next()) {
                return rs.getBoolean("store");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     *
     * @return
     */
    public int insertStoreBook(String username, String bookId) {
        String sql = "insert into borrow_books(book_id, card_id, " + "borrow_date) values(?,?,?)";
        int result = JDBCUtil.getInstance().executeUpdate(sql, new Object[]{
                        bookId, username,
                        new Date(System.currentTimeMillis())
                });
        return result;
    }

    /**
     * 查询在借图书
     * @return
     */
    public List<Books>  selectBorrowBooks(int pageNum, int pageSize ,String id){
        String sql = "select books.author,books.name,books.description,borrow_card.id \n" +
                "from books left join borrow_books on borrow_books.book_id = books.id \n" +
                "left join borrow_card  on borrow_card.id = borrow_books.card_id where not isnull " +
                "(borrow_card.id) and borrow_card.id = ? limit ?,? ";

        List<Books> books =new ArrayList<>();
        try( ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql,
                new Object[]{id,(pageNum - 1) * pageSize, pageSize})) {
            while (rs.next()){
                Books book = new Books(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getString("description")
                        );
                books.add(book);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public  int countBorrowBooks(String userId){
        String sql ="select count(*) as borrowNum  FROM borrow_books where card_id = ?";
        try (ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{userId})) {
            while (rs.next()) {
                return rs.getInt("borrowNum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

        return 0;

    }



    /**
     *管理员添加图书
     * @return
     */
   public int addBooks(String name,String author,String description){
        String sql = "insert into books  values(?,?,?)";
        int  result = JDBCUtil.getInstance().executeUpdate(sql, new Object[]{
                name,author,description,new Date(System.currentTimeMillis())
        });
        return result;
        }

    /**
     *管理员删除图书
     * @return
     */
        public  int deleteBooks(String id){
        String sql = "UPDATE books WHERE id=?";
            int result =JDBCUtil.getInstance().executeUpdate(sql, new Object[]{
                    id,new Date(System.currentTimeMillis())
            });
            System.out.println("删除时的SQL："+sql);
            return result;
        }

}
