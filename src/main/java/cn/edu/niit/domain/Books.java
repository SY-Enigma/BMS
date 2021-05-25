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
    private  String illegal;
    private  String borrow_date;
    private  String return_date;

    public Books(String id, String name, String author, String sort, String description, boolean store) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.sort = sort;
        this.description = description;
        this.store = store;
    }

    public Books(String id, String name, String author, String sort, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.sort = sort;
        this.description = description;
    }

    public Books(String id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public Books(String id, String name, String author, String description, String illegal,
                 String borrow_date, String return_date) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.illegal = illegal;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
    }

}
