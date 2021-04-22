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
    private String id;
    private String name;
    private String author;
    private String sort;
    private String description;
    private boolean store;

    public Books(String id, String name, String author, String sort,
                String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.sort = sort;
        this.description = description;
    }

}
