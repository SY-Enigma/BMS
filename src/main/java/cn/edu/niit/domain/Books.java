package cn.edu.niit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Books
 * @Description TODO
 * @Author SY
 * @Date 2021/4/13
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Books {
    private  String mane;
    private  String author;
    private  String  sort;
    private  String description;


}
