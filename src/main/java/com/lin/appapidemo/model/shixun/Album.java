package com.lin.appapidemo.model.shixun;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_album")
public class Album {
    @Id
    @Column(name = "aid")
    private int aid;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publishtime")
    private String publishtime;
    @Column(name = "num")
    private int num;
    @Column(name = "descri")
    private String descri;
    @Column(name = "time")
    private String time;
    @Transient
    private List<Subalbum> subalbums;

    public Album(String title, String author, String publisher, String publishtime, int num, String descri, String time) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishtime = publishtime;
        this.num = num;
        this.descri = descri;
        this.time = time;
    }
}
