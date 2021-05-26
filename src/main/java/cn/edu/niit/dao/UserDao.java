package cn.edu.niit.dao;

import cn.edu.niit.db.JDBCUtil;
import cn.edu.niit.domain.Admin;
import cn.edu.niit.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author SY
 * @Date 2021/3/23
 **/
public class UserDao extends JDBCUtil {

    public  User selectOne(String username) {
        String sql ="select * from borrow_card where username=?";
        User user = null;
        try (ResultSet resultSet = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{username})) {

            while (resultSet.next()) {
                user = new User(
                        resultSet.getString("id"),
                        resultSet.getString("username"),
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

    public List<User> selectUser(int pageNum, int pageSize){
        String sql ="select * from borrow_card limit ?,?";
        List<User> users = new ArrayList<>();
        try (ResultSet resultSet = JDBCUtil.getInstance().executeQueryRS(sql,
                new Object[]{(pageNum - 1) * pageSize, pageSize})) {
            while (resultSet.next()) {
               User user = new User(
                        resultSet.getString("id"),
                        resultSet.getString("username"),
                        resultSet.getString("reader"),
                        resultSet.getString("header"),
                        resultSet.getString("cellPhone"),
                        resultSet.getBoolean("sex"),
                        resultSet.getString("email"),
                        resultSet.getString("describe"));
               users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public  int countUser(){
       String sql ="SELECT count(*) as userNum FROM borrow_card";
        try (ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{})) {
            while (rs.next()) {
                return rs.getInt("userNum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

        return 0;

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
                admin = new Admin(
                        resultSet.getString("username"),
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

    //注册

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

    //

    public int updateOne(User user) {
        int result = 0;
        StringBuilder sb = new StringBuilder("update borrow_card " +
                "set reader=?, cellphone=?, email=?, sex=?, " +
                "borrow_card.`describe`=? ");
        if (user.getHeader() != null) {
            sb.append(", header=? where " + "username=?");
            result = JDBCUtil.getInstance().executeUpdate(sb.toString(),
                            new Object[]{
                                    user.getReader(),
                                    user.getCellPhone(),
                                    user.getEmail(), user.isSex(),
                                    user.getDescribe(),
                                    user.getHeader(),
                                    user.getUsername()});
    } else {
        sb.append("where username=?");
        result = JDBCUtil.getInstance().executeUpdate(sb.toString(),
                            new Object[]{
                                    user.getReader(),
                                    user.getCellPhone(),
                                    user.getEmail(), user.isSex(),
                                    user.getDescribe(),
                                    user.getUsername()});
        }
        return result;
    }


}
