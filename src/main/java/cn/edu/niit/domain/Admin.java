package cn.edu.niit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author SY
 * @Date 2021/3/30
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    private  String username;
    private  String  password;
    private  String  reader;
    private  String  header;
    private  String cellPhone;
    private  boolean sex;


    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
