package cn.edu.niit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description TODO
 * @Author SY
 * @Date 2021/3/23
 **/
@Data
@NoArgsConstructor

public class User {
    private String username;
    private  String password;
    private  String  reader;
    private  String  header;
    private  String cellPhone;
    private  boolean sex;
    private  String email;
    private  String describe;

    public User(String username, String password, String reader, String header, String cellPhone, boolean sex,
                String email, String describe) {
        this.username = username;
        this.password = password;
        this.reader = reader;
        this.header = header;
        this.cellPhone = cellPhone;
        this.sex = sex;
        this.email = email;
        this.describe = describe;
    }

    public User(String username, String password, String reader) {
        this.username = username;
        this.password = password;
        this.reader = reader;
    }
}
