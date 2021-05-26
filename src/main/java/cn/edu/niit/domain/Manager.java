package cn.edu.niit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Manager
 * @Description TODO
 * @Author SY
 * @Date 2021/5/26
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Manager {
    private  String id;
    private  String name;
    private  String account;
    private  String  password;
    private  String email;
}
