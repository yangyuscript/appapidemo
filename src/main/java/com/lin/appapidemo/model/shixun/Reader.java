package com.lin.appapidemo.model.shixun;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_reader")
public class Reader {
    @Id
    @Column(name = "rid")
    private int rid;
    @Column(name = "account")
    /**
     * 学号
     */
    private String account;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;
    @Column(name = "time")
    private String time;
    @Column(name = "condi")
    private int condi;

    public Reader(String account, String password, String name, String sex, String time, int condi) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.time = time;
        this.condi = condi;
    }
}
