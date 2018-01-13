package com.lin.appapidemo.model.shixun;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_borrowrecord")
public class Borrowrecord {
    @Id
    @Column(name = "bid")
    private int bid;
    @Column(name = "rid")
    private int rid;
    @Column(name = "raccount")
    private String raccount;
    @Column(name = "aid")
    private int aid;
    @Column(name = "sid")
    private int sid;
    @Column(name = "time")
    private String time;
    @Column(name = "backtime")
    private String backtime;
    @Column(name = "inttime")
    private String inttime;
    @Transient
    private Reader reader;
    @Transient
    private Album album;
    @Transient
    private Subalbum subalbum;

    public Borrowrecord(int rid, String raccount, int aid, int sid, String time, String backtime,String inttime) {
        this.rid = rid;
        this.raccount = raccount;
        this.aid = aid;
        this.sid = sid;
        this.time = time;
        this.backtime = backtime;
        this.inttime = inttime;
    }
}
