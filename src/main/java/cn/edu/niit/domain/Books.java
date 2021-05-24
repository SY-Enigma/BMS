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

@NoArgsConstructor
@Data

public class Books {
    private String id;
    private String name;
    private String author;
    private String sort;
    private String description;
    private boolean store;

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
}
