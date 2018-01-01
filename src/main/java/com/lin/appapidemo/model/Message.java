package com.lin.appapidemo.model;

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
@Table(name = "t_message")
public class Message {
    @Id
    private int mid;
    @Column(name = "fromuserid")
    private int fromuserid;
    @Column(name = "touserid")
    private int touserid;
    @Column(name = "content")
    private String content;
    @Column(name = "condi")
    private int condi;
    @Column(name = "time")
    private String time;
    @Transient
    private User fromuser;
    @Transient
    private User touser;

    public Message(int fromuserid, int touserid, String content, int condi, String time) {
        this.fromuserid = fromuserid;
        this.touserid = touserid;
        this.content = content;
        this.condi = condi;
        this.time = time;
    }
}
