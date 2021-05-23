package cn.edu.niit.dao;

import cn.edu.niit.db.JDBCUtil;
import cn.edu.niit.domain.Announcement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AnnouncementDao
 * @Description TODO
 * @Author SY
 * @Date 2021/4/18
 **/
public class AnnouncementDao {
    public  List<Announcement> selectAll( int pageSize,int pageNum,String title ) {
        List<Announcement> announcements = new ArrayList<>();

       try ( ResultSet resultSet = (ResultSet) JDBCUtil.getInstance().excuteQuery("select * from announcement  ",
               new Object[]{title,(pageNum - 1) * pageSize, pageSize})){
           while (resultSet.next()){
               Announcement  announcement = new Announcement(
                       resultSet.getString("id"),
                       resultSet.getString("title"),
                       resultSet.getString("detail"),
                       resultSet.getString("publish_date"));

               announcements.add(announcement);
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }

        return announcements;
    }
  public  int countAnnouncement(String annId){
        String sql = "select count(*) as countNum from announcement where id ";
        try (ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{annId})){
            while (rs.next()){
                int count  = rs.getInt("countNum");
                return count;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
  }

}
