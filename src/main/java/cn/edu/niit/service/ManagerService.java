package cn.edu.niit.service;

import cn.edu.niit.dao.ManagerDao;
import cn.edu.niit.domain.Manager;

import java.util.List;

/**
 * @ClassName ManagerService
 * @Description TODO
 * @Author SY
 * @Date 2021/5/26
 **/
public class ManagerService {
    ManagerDao managerDao  = new ManagerDao();

    public  List<Manager> searchManager(int pageNum, int pageSize){
        List<Manager> managers = managerDao.selectAll(pageNum, pageSize);
        return  managers;

    }
    public  int countManager(){
        return managerDao.countManager();
    }
}
