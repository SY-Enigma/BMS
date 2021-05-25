package cn.edu.niit.service;

import cn.edu.niit.dao.AnnouncementDao;
import cn.edu.niit.domain.Announcement;

import java.util.List;


/**
 * @ClassName AnnouncementService
 * @Description TODO
 * @Author SY
 * @Date 2021/4/18
 **/
public class AnnouncementService {
  private  AnnouncementDao announcementDao = new AnnouncementDao();

   public  List<Announcement> searchAllAnnouncement(int pageNum, int pageSize){
     List<Announcement> announcements = announcementDao.selectAll(pageNum, pageSize);
     return announcements;

   }
    public int searchAnnouncement(){

      return announcementDao.countAnnouncement();

    }


}
