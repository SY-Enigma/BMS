package cn.edu.niit.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Announcement
 * @Description TODO
 * @Author SY
 * @Date 2021/4/18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    private String title;
    private  String detail;
    private Date publish_date;
}
