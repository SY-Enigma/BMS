package cn.edu.niit.dao;

import cn.edu.niit.db.JDBCUtil;
import cn.edu.niit.domain.Manager;
import cn.edu.niit.domain.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ManagerDao
 * @Description TODO
 * @Author SY
 * @Date 2021/5/26
 **/
public class ManagerDao {

    public  List<Manager> selectAll(int pageNum, int pageSize){
        String sql ="select * from manager limit ?,?";
        List<Manager> managers = new ArrayList<>();
        try (ResultSet resultSet = JDBCUtil.getInstance().executeQueryRS(sql,
                new Object[]{(pageNum - 1) * pageSize, pageSize})) {
            while (resultSet.next()) {
                Manager manager = new Manager(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("account"),
                        resultSet.getString("password"),
                        resultSet.getString("email")
                );
                managers.add(manager);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managers;
    }

    public int countManager(){
        String sql = "SELECT count(*) as managerNum FROM manager";
        try (ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{})){
            while (rs.next()){
                int count  = rs.getInt("managerNum");

                return count;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
