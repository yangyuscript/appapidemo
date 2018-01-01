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
@Table(name = "t_position")
public class Position {
    @Id
    private int pid;
    @Column(name="userid")
    private int userid;
    @Column(name = "address")
    private String address;
    @Column(name = "time")
    private String time;

    public Position(int userid, String address, String time) {
        this.userid = userid;
        this.address = address;
        this.time = time;
    }
}
