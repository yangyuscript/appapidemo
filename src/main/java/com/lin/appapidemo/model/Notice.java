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
@Table(name = "t_notice")
public class Notice {
    @Id
    private int nid;
    @Column(name = "title")
    private String varchar;
    @Column(name = "content")
    private String content;
    @Column(name = "condi")
    private int condi;
    @Column(name = "time")
    private String time;

    public Notice(String varchar, String content, int condi, String time) {
        this.varchar = varchar;
        this.content = content;
        this.condi = condi;
        this.time = time;
    }
}
