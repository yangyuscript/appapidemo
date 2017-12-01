package com.lin.appapidemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Accessors(chain=true)
@Table(name="t_user")
public class User {
    @Column(name="userid")
    private int userId;
    @Column(name="email")
    private String email;
    @Column(name="nickname")
    private String nickname;
    @Column(name="password")
    private String password;
    @Column(name="head")
    private String head;
    @Column(name="credit")
    private int credit;
    @Column(name="condi")
    private int condi;

    public User(String email, String nickname, String password, String head, int credit, int condi) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.head = head;
        this.credit = credit;
        this.condi = condi;
    }


}
