package cn.edu.niit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Message
 * @Description TODO
 * @Author SY
 * @Date 2021/5/25
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message {
    private String id;
    private  String detail;
    private String cardId;
    private  String publicDate;

}
