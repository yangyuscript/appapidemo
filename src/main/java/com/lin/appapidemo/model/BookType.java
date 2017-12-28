package com.lin.appapidemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name="t_booktype")
public class BookType {
    @Id
    private int btid;
    @Column(name = "name")
    private String name;
    @Column(name = "time")
    private String time;

    public BookType(String name, String time) {
        this.name = name;
        this.time = time;
    }
}
