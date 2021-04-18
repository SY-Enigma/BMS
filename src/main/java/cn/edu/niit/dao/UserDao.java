package cn.edu.niit.dao;

import cn.edu.niit.db.JDBCUtil;
import cn.edu.niit.domain.Admin;
import cn.edu.niit.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author SY
 * @Date 2021/3/23
 **/
public class UserDao extends JDBCUtil {

    public  User selectOne(String username) {
        User user = null;
        try (ResultSet resultSet =
                     JDBCUtil.getInstance().executeQueryRS("select " +
                                     "* " +
                                     "from " +
                                     "borrow_card where username=?",
                             new Object[]{username})) {

            while (resultSet.next()) {
                user = new User(resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("reader"),
                        resultSet.getString("header"),
                        resultSet.getString("cellPhone"),
                        resultSet.getBoolean("sex"),
                        resultSet.getString("email"),
                        resultSet.getString("describe"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user;
    }
    public Admin selectOne(String username, String password) {
        Admin admin = null;
        try (ResultSet resultSet =
                     JDBCUtil.getInstance().executeQueryRS("select " +
                                     "* " +
                                     "from " +
                                     "admin where username=?",
                             new Object[]{username})) {

            while (resultSet.next()) {
                admin = new Admin(resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("reader"),
                        resultSet.getString("header"),
                        resultSet.getString("cellPhone"),
                        resultSet.getBoolean("sex")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }

    private Connection conn = null;
    private PreparedStatement ps=null;
    private int result=0;
    private ResultSet rs=null;
    public int register(User register) throws SQLException {
        String sql="insert into borrow_card(username,password,reader) value (?,?,?)";
        try {
            //获取数据库连接对象
            conn= this.getConnection();
            //获取数据库操作对象
            ps=conn.prepareStatement(sql);
            ps.setString(1,register.getUsername());
            ps.setString(2,register.getPassword());
            ps.setString(3,register.getReader());
            //执行sql
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            conn.close();
            ps.close();


        }
        return result;
    }
}
