package cn.edu.niit.servlet;

import cn.edu.niit.dao.AnnouncementDao;
import cn.edu.niit.domain.Announcement;
import cn.edu.niit.service.AnnouncementService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName AnnouncementServlet
 * @Description TODO
 * @Author SY
 * @Date 2021/4/18
 **/

@WebServlet(name = "AnnouncementServlet" , urlPatterns = "/notification")
public class AnnouncementServlet extends HttpServlet {

    private AnnouncementDao announcementDao = new AnnouncementDao();
    private  AnnouncementService announcementService = new AnnouncementService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramJson = IOUtils.toString(req.getInputStream(), "UTF-8");
        HashMap<String, Object> parseObject = JSON.parseObject(paramJson, HashMap.class);
        String param = (String) parseObject.get("search");
        //
        HttpSession session = req.getSession();
        Announcement announcement = (Announcement) session.getAttribute("announcement");
        String annId = announcement.getId();

        int pageNUm = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<Announcement> announcements = new ArrayList<>();
        int count = 0;
        String annTitle = announcement.getTitle();

        if (param != null){
            //带参数查询
        }else {
            announcements = announcementDao.selectAll(pageSize,pageNUm,annTitle);
        }
        count = announcementService.Announcement1(annId);
        req.getSession().setAttribute("announcements",announcements);
        resp.getWriter().print(count);
    }


}
