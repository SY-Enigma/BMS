package cn.edu.niit.service;

import cn.edu.niit.dao.AnnouncementDao;


/**
 * @ClassName AnnouncementService
 * @Description TODO
 * @Author SY
 * @Date 2021/4/18
 **/
public class AnnouncementService {
  private  AnnouncementDao announcementDao = new AnnouncementDao();
    public int Announcement1(String annId){

      return announcementDao.countAnnouncement(annId);

    }
}
